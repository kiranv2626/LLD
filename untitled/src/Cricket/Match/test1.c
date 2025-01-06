#include "userprog/process.h"
#include <debug.h>
#include <inttypes.h>
#include <round.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "userprog/gdt.h"
#include "userprog/pagedir.h"
#include "userprog/tss.h"
#include "filesys/directory.h"
#include "filesys/file.h"
#include "filesys/filesys.h"
#include "threads/flags.h"
#include "threads/init.h"
#include "threads/interrupt.h"
#include "threads/palloc.h"
#include "threads/thread.h"
#include "threads/vaddr.h"
#include "threads/malloc.h"
#include "devices/timer.h"
#include "userprog/syscall.h"

static thread_func start_process NO_RETURN;
static bool load (const char *cmdline, void (**eip) (void), void **esp);

//creating a child thread and tracking it
static tid_t create_and_track_child_thread(char *fn_copy) {
    char *cmd_name, *args;
    //command name and arguments
    cmd_name = strtok_r(fn_copy, " ", &args);
    //creating thread
    tid_t tid = thread_create(cmd_name, PRI_DEFAULT, start_process, args);
    //thread creation failure
    if (tid == TID_ERROR) {
        //free allocated memory on failure
        palloc_free_page(fn_copy);
        return TID_ERROR;
    }
    //current thread
    struct thread *cur = thread_current();
    //allocating memory for child status
    struct ch_status *child = calloc(1, sizeof(*child));
    //intializing child status and link it to parents child list
    if (child != NULL) {
        child->ch_id = tid;
        child->exit_calld = false;
        child->waitd = false;
        list_push_back(&cur->childrn, &child->elem_ch_status);
    }
    return tid;
}

/* Starts a new thread running a user program loaded from
   FILENAME.  The new thread may be scheduled (and may even exit)
   before process_execute() returns.  Returns the new process's
   thread id, or TID_ERROR if the thread cannot be created. */
tid_t
process_execute (const char *file_name)
{
  char *fn_copy;
  tid_t tid;
  /* Make a copy of FILE_NAME.
     Otherwise there's a race between the caller and load(). */
  fn_copy = palloc_get_page (0);
  if (fn_copy == NULL)
    return TID_ERROR;
  strlcpy (fn_copy, file_name, PGSIZE);
  //creating thread
  tid = create_and_track_child_thread(fn_copy);
  return tid;
}

//handle loading status and notify parent thread
static void handle_load_status(bool success, const char *file_name) {
    //setting load status based on success
    int load_status = success ? 1 : -1;
    //current thread
    struct thread *cur= thread_current();
    //parent thread
    struct thread *par= find_thread_by_id(cur->pr_id);
    if (par != NULL) {
        //acquire parent lock
        lock_acquire(&par->c_lock);
        //update load status
        par->ch_status_load = load_status;
         //signal parent
        cond_signal(&par->cond_c, &par->c_lock);
        //release parent lock
        lock_release(&par->c_lock);
    }
    if (!success)
        thread_exit();
    //free allocated memory for file name
    palloc_free_page(pg_round_down(file_name));
}

/* A thread function that loads a user process and starts it
   running. */
static void
start_process (void *file_name_)
{
  char *file_name = file_name_;
  struct intr_frame if_;
  bool success;

  /* Initialize interrupt frame and load executable. */
  memset (&if_, 0, sizeof if_);
  if_.gs = if_.fs = if_.es = if_.ds = if_.ss = SEL_UDSEG;
  if_.cs = SEL_UCSEG;
  if_.eflags = FLAG_IF | FLAG_MBS;
  //loading executable into memory
  success = load (file_name, &if_.eip, &if_.esp);
   //handle load status and notify parent
  handle_load_status(success, file_name);

  /* Start the user process by simulating a return from an
     interrupt, implemented by intr_exit (in
     threads/intr-stubs.S).  Because intr_exit takes all of its
     arguments on the stack in the form of a `struct intr_frame',
     we just point the stack pointer (%esp) to our stack frame
     and jump to it. */
  asm volatile ("movl %0, %%esp; jmp intr_exit" : : "g" (&if_) : "memory");
  NOT_REACHED ();
}
//finding child in  parent's child list
static struct ch_status *find_child(struct thread *parent, tid_t child_tid) {
    //starting at list tail
    struct list_elem *elem = list_tail(&parent->childrn);
    //traversing child list
    while ((elem = list_prev(elem)) != list_head(&parent->childrn)) {
        //getting child entry
        struct ch_status *child = list_entry(elem, struct ch_status, elem_ch_status);
        //checking if IDs match
        if (child->ch_id == child_tid)
            return child;
    }
    //returning NULL if child not found
    return NULL;
}

//waiting for the child process to exit
static int wait_for_child(struct thread *parent, struct ch_status *child) {
    int exit_status;
    //lock for synchronization
    lock_acquire(&parent->c_lock);
    //wait until the child process exits
    while (find_thread_by_id(child->ch_id) != NULL)
        cond_wait(&parent->cond_c, &parent->c_lock);
    //handling invalid states
    if (child->exit_calld == false || child->waitd == true) {
        exit_status = -1;
    } else {
        //get child's exit status
        exit_status = child->ch_ext_sta;
        //marking child as waited
        child->waitd = true;
    }
    //releasing lock after processing
    lock_release(&parent->c_lock);
    return exit_status;
}

/* Waits for thread TID to die and returns its exit status.  If
   it was terminated by the kernel (i.e. killed due to an
   exception), returns -1.  If TID is invalid or if it was not a
   child of the calling process, or if process_wait() has already
   been successfully called for the given TID, returns -1
   immediately, without waiting.

   This function will be implemented in problem 2-2.  For now, it
   does nothing. */
int
process_wait (tid_t child_tid)
{
  //handling invalid thread ID
    if (child_tid == TID_ERROR)
        return -1;
    //current thread
    struct thread *curr = thread_current();
    //finding child in list
    struct ch_status *child = find_child(curr, child_tid);
    //-1 if child not found
    if (child == NULL)
        return -1;
    //wait for the child to finish
    return wait_for_child(curr, child);
}

//notify parent about thread's exit
static void notify_parent(struct thread *curr) {
    //parent thread
    struct thread *parent = find_thread_by_id(curr->pr_id);
    //notify parent if it exists
    if (parent != NULL) {
       //acquire parent lock
        lock_acquire(&parent->c_lock);
        //update parent's child load status
        if (parent->ch_status_load == 0)
            parent->ch_status_load = -1;
        //signal parent about the thread's exit
        cond_signal(&parent->cond_c, &parent->c_lock);
        lock_release(&parent->c_lock);
    }
}

//free child list, close files, and notify parent
static void cleanup_resources(struct thread *curr) {
    //starting from child list head
    struct list_elem *elem = list_begin(&curr->childrn);
    struct list_elem *next;
    struct ch_status *child;
    //free child list
    while (elem != list_tail(&curr->childrn)) {
        //getting next element
        next = list_next(elem);
        child = list_entry(elem, struct ch_status, elem_ch_status);
        //remove
        list_remove(elem);
        //free memory
        free(child);
        //next element
        elem = next;
    }
    //file's writable property
    if (curr->exec_f != NULL)
        file_allow_write(curr->exec_f);
    //all files owned by thread
    close_file_by_owner(curr->tid);
    //notify parent about thread's exit
    notify_parent(curr);
}




/* Free the current process's resources. */
void
process_exit (void)
{
  struct thread *cur = thread_current ();
  uint32_t *pd;
  /* Destroy the current process's page directory and switch back
     to the kernel-only page directory. */
  pd = cur->pagedir;
  if (pd != NULL)
    {
      /* Correct ordering here is crucial.  We must set
         cur->pagedir to NULL before switching page directories,
         so that a timer interrupt can't switch back to the
         process page directory.  We must activate the base page
         directory before destroying the process's page
         directory, or our active page directory will be one
         that's been freed (and cleared). */
      cur->pagedir = NULL;
      pagedir_activate (NULL);
      pagedir_destroy (pd);
    }
    //clean up resources and notify the parent
    cleanup_resources(cur);
}

/* Sets up the CPU for running user code in the current
   thread.
   This function is called on every context switch. */
void
process_activate (void)
{
  struct thread *t = thread_current ();

  /* Activate thread's page tables. */
  pagedir_activate (t->pagedir);

  /* Set thread's kernel stack for use in processing
     interrupts. */
  tss_update ();
}

/* We load ELF binaries.  The following definitions are taken
   from the ELF specification, [ELF1], more-or-less verbatim.  */

/* ELF types.  See [ELF1] 1-2. */
typedef uint32_t Elf32_Word, Elf32_Addr, Elf32_Off;
typedef uint16_t Elf32_Half;

/* For use with ELF types in printf(). */
#define PE32Wx PRIx32   /* Print Elf32_Word in hexadecimal. */
#define PE32Ax PRIx32   /* Print Elf32_Addr in hexadecimal. */
#define PE32Ox PRIx32   /* Print Elf32_Off in hexadecimal. */
#define PE32Hx PRIx16   /* Print Elf32_Half in hexadecimal. */

/* Executable header.  See [ELF1] 1-4 to 1-8.
   This appears at the very beginning of an ELF binary. */
struct Elf32_Ehdr
  {
    unsigned char e_ident[16];
    Elf32_Half    e_type;
    Elf32_Half    e_machine;
    Elf32_Word    e_version;
    Elf32_Addr    e_entry;
    Elf32_Off     e_phoff;
    Elf32_Off     e_shoff;
    Elf32_Word    e_flags;
    Elf32_Half    e_ehsize;
    Elf32_Half    e_phentsize;
    Elf32_Half    e_phnum;
    Elf32_Half    e_shentsize;
    Elf32_Half    e_shnum;
    Elf32_Half    e_shstrndx;
  };

/* Program header.  See [ELF1] 2-2 to 2-4.
   There are e_phnum of these, starting at file offset e_phoff
   (see [ELF1] 1-6). */
struct Elf32_Phdr
  {
    Elf32_Word p_type;
    Elf32_Off  p_offset;
    Elf32_Addr p_vaddr;
    Elf32_Addr p_paddr;
    Elf32_Word p_filesz;
    Elf32_Word p_memsz;
    Elf32_Word p_flags;
    Elf32_Word p_align;
  };

/* Values for p_type.  See [ELF1] 2-3. */
#define PT_NULL    0            /* Ignore. */
#define PT_LOAD    1            /* Loadable segment. */
#define PT_DYNAMIC 2            /* Dynamic linking info. */
#define PT_INTERP  3            /* Name of dynamic loader. */
#define PT_NOTE    4            /* Auxiliary info. */
#define PT_SHLIB   5            /* Reserved. */
#define PT_PHDR    6            /* Program header table. */
#define PT_STACK   0x6474e551   /* Stack segment. */

/* Flags for p_flags.  See [ELF3] 2-3 and 2-4. */
#define PF_X 1          /* Executable. */
#define PF_W 2          /* Writable. */
#define PF_R 4          /* Readable. */

static bool setup_stack (void **esp, const char *file_name);
static bool validate_segment (const struct Elf32_Phdr *, struct file *);
static bool load_segment (struct file *file, off_t ofs, uint8_t *upage,
                          uint32_t read_bytes, uint32_t zero_bytes,
                          bool writable);

/* Loads an ELF executable from FILE_NAME into the current thread.
   Stores the executable's entry point into *EIP
   and its initial stack pointer into *ESP.
   Returns true if successful, false otherwise. */
bool
load (const char *file_name, void (**eip) (void), void **esp)
{
  struct thread *t = thread_current ();
  struct Elf32_Ehdr ehdr;
  struct file *file = NULL;
  off_t file_ofs;
  bool success = false;
  int i;

  /* Allocate and activate page directory. */
  t->pagedir = pagedir_create ();
  if (t->pagedir == NULL)
    goto done;
  process_activate ();

  /* Open executable file. */
  //file = filesys_open (file_name);
  file = filesys_open (t->name);
  if (file == NULL)
    {
      printf ("load: %s: open failed\n", t->name);
      file_close (file);
      goto done;
    }

  t->exec_f = file;
  file_deny_write (file);

  /* Read and verify executable header. */
  if (file_read (file, &ehdr, sizeof ehdr) != sizeof ehdr
      || memcmp (ehdr.e_ident, "\177ELF\1\1\1", 7)
      || ehdr.e_type != 2
      || ehdr.e_machine != 3
      || ehdr.e_version != 1
      || ehdr.e_phentsize != sizeof (struct Elf32_Phdr)
      || ehdr.e_phnum > 1024)
    {
      printf ("load: %s: error loading executable\n", t->name);
      goto done;
    }

  /* Read program headers. */
  file_ofs = ehdr.e_phoff;
  for (i = 0; i < ehdr.e_phnum; i++)
    {
      struct Elf32_Phdr phdr;

      if (file_ofs < 0 || file_ofs > file_length (file))
        goto done;
      file_seek (file, file_ofs);

      if (file_read (file, &phdr, sizeof phdr) != sizeof phdr)
        goto done;
      file_ofs += sizeof phdr;
      switch (phdr.p_type)
        {
        case PT_NULL:
        case PT_NOTE:
        case PT_PHDR:
        case PT_STACK:
        default:
          /* Ignore this segment. */
          break;
        case PT_DYNAMIC:
        case PT_INTERP:
        case PT_SHLIB:
          goto done;
        case PT_LOAD:
          if (validate_segment (&phdr, file))
            {
              bool writable = (phdr.p_flags & PF_W) != 0;
              uint32_t file_page = phdr.p_offset & ~PGMASK;
              uint32_t mem_page = phdr.p_vaddr & ~PGMASK;
              uint32_t page_offset = phdr.p_vaddr & PGMASK;
              uint32_t read_bytes, zero_bytes;
              if (phdr.p_filesz > 0)
                {
                  /* Normal segment.
                     Read initial part from disk and zero the rest. */
                  read_bytes = page_offset + phdr.p_filesz;
                  zero_bytes = (ROUND_UP (page_offset + phdr.p_memsz, PGSIZE)
                                - read_bytes);
                }
              else
                {
                  /* Entirely zero.
                     Don't read anything from disk. */
                  read_bytes = 0;
                  zero_bytes = ROUND_UP (page_offset + phdr.p_memsz, PGSIZE);
                }
              if (!load_segment (file, file_page, (void *) mem_page,
                                 read_bytes, zero_bytes, writable))
                goto done;
            }
          else
            goto done;
          break;
        }
    }

  /* Set up stack. */
  if (!setup_stack (esp, file_name))
    goto done;

  /* Start address. */
  *eip = (void (*) (void)) ehdr.e_entry;

  success = true;

 done:
  /* We arrive here whether the load is successful or not. */
  //file_close (file);
  return success;
}

/* load() helpers. */

static bool install_page (void *upage, void *kpage, bool writable);

/* Checks whether PHDR describes a valid, loadable segment in
   FILE and returns true if so, false otherwise. */
static bool
validate_segment (const struct Elf32_Phdr *phdr, struct file *file)
{
  /* p_offset and p_vaddr must have the same page offset. */
  if ((phdr->p_offset & PGMASK) != (phdr->p_vaddr & PGMASK))
    return false;

  /* p_offset must point within FILE. */
  if (phdr->p_offset > (Elf32_Off) file_length (file))
    return false;

  /* p_memsz must be at least as big as p_filesz. */
  if (phdr->p_memsz < phdr->p_filesz)
    return false;

  /* The segment must not be empty. */
  if (phdr->p_memsz == 0)
    return false;

  /* The virtual memory region must both start and end within the
     user address space range. */
  if (!is_user_vaddr ((void *) phdr->p_vaddr))
    return false;
  if (!is_user_vaddr ((void *) (phdr->p_vaddr + phdr->p_memsz)))
    return false;

  /* The region cannot "wrap around" across the kernel virtual
     address space. */
  if (phdr->p_vaddr + phdr->p_memsz < phdr->p_vaddr)
    return false;

  /* Disallow mapping page 0.
     Not only is it a bad idea to map page 0, but if we allowed
     it then user code that passed a null pointer to system calls
     could quite likely panic the kernel by way of null pointer
     assertions in memcpy(), etc. */
  if (phdr->p_vaddr < PGSIZE)
    return false;

  /* It's okay. */
  return true;
}

/* Loads a segment starting at offset OFS in FILE at address
   UPAGE.  In total, READ_BYTES + ZERO_BYTES bytes of virtual
   memory are initialized, as follows:

        - READ_BYTES bytes at UPAGE must be read from FILE
          starting at offset OFS.

        - ZERO_BYTES bytes at UPAGE + READ_BYTES must be zeroed.

   The pages initialized by this function must be writable by the
   user process if WRITABLE is true, read-only otherwise.

   Return true if successful, false if a memory allocation error
   or disk read error occurs. */
static bool
load_segment (struct file *file, off_t ofs, uint8_t *upage,
              uint32_t read_bytes, uint32_t zero_bytes, bool writable)
{
  ASSERT ((read_bytes + zero_bytes) % PGSIZE == 0);
  ASSERT (pg_ofs (upage) == 0);
  ASSERT (ofs % PGSIZE == 0);

  file_seek (file, ofs);
  while (read_bytes > 0 || zero_bytes > 0)
    {
      /* Calculate how to fill this page.
         We will read PAGE_READ_BYTES bytes from FILE
         and zero the final PAGE_ZERO_BYTES bytes. */
      size_t page_read_bytes = read_bytes < PGSIZE ? read_bytes : PGSIZE;
      size_t page_zero_bytes = PGSIZE - page_read_bytes;

      /* Get a page of memory. */
      uint8_t *kpage = palloc_get_page (PAL_USER);
      if (kpage == NULL)
        return false;

      /* Load this page. */
      if (file_read (file, kpage, page_read_bytes) != (int) page_read_bytes)
        {
          palloc_free_page (kpage);
          return false;
        }
      memset (kpage + page_read_bytes, 0, page_zero_bytes);

      /* Add the page to the process's address space. */
      if (!install_page (upage, kpage, writable))
        {
          palloc_free_page (kpage);
          return false;
        }

      /* Advance. */
      read_bytes -= page_read_bytes;
      zero_bytes -= page_zero_bytes;
      upage += PGSIZE;
    }
  return true;
}

//push arguments and metadata onto stack
static bool setup_arguments_and_metadata(void **esp, const char *file_name) {
    uint8_t *argstr_head;
    //command name
    char *cmd_name = thread_current()->name;
    int total_length = 0, argc = 0;
    //push file name onto stack
    int strlength = strlen(file_name) + 1;
    *esp -= strlength;
    memcpy(*esp, file_name, strlength);
    total_length += strlength;
    //push command name onto stack
    strlength = strlen(cmd_name) + 1;
    *esp -= strlength;
    argstr_head = *esp;
    memcpy(*esp, cmd_name, strlength);
    total_length += strlength;
    //align stack to word boundary
    *esp -= 4 - total_length % 4;
    //push a null pointer for argv[argc]
    *esp -= 4;
    *(uint32_t *)*esp = (uint32_t)NULL;
    //push addresses of arguments onto the stack
    int i = total_length - 1;
    while (*(argstr_head + i) == ' ' || *(argstr_head + i) == '\0') {
        if (*(argstr_head + i) == ' ')
            *(argstr_head + i) = '\0';
        i--;
    }
    char *mark;
    for (mark = (char *)(argstr_head + i); i > 0; i--, mark = (char *)(argstr_head + i)) {
        if ((*mark == '\0' || *mark == ' ') &&
            (*(mark + 1) != '\0' && *(mark + 1) != ' ')) {
            *esp -= 4;
            *(uint32_t *)*esp = (uint32_t)(mark + 1);
            argc++;
        }
        if (*mark == ' ')
            *mark = '\0';
    }
    //push command name address
    *esp -= 4;
    *(uint32_t *)*esp = (uint32_t)argstr_head;
    argc++;
    //push argv
    *(uint32_t *)(*esp - 4) = *(uint32_t *)*esp;
    *esp -= 4;
    //push argc
    *esp -= 4;
    *(int *)*esp = argc;
    //push return address
    *esp -= 4;
    *(uint32_t *)*esp = 0x0;
    return true;
}


/* Create a minimal stack by mapping a zeroed page at the top of
   user virtual memory. */
static bool
setup_stack (void **esp, const char *file_name)
{
  uint8_t *kpage;
  bool success = false;

  kpage = palloc_get_page (PAL_USER | PAL_ZERO);
  if (kpage != NULL) {
        success = install_page(((uint8_t *)PHYS_BASE) - PGSIZE, kpage, true);
        if (success) {
            //stack pointer
            *esp = PHYS_BASE;
            success = setup_arguments_and_metadata(esp, file_name);
        } else {
            palloc_free_page(kpage); // Free page if installation fails
        }
    }
  return success;
}

/* Adds a mapping from user virtual address UPAGE to kernel
   virtual address KPAGE to the page table.
   If WRITABLE is true, the user process may modify the page;
   otherwise, it is read-only.
   UPAGE must not already be mapped.
   KPAGE should probably be a page obtained from the user pool
   with palloc_get_page().
   Returns true on success, false if UPAGE is already mapped or
   if memory allocation fails. */
static bool
install_page (void *upage, void *kpage, bool writable)
{
  struct thread *t = thread_current ();

  /* Verify that there's not already a page at that virtual
     address, then map our page there. */
  return (pagedir_get_page (t->pagedir, upage) == NULL
          && pagedir_set_page (t->pagedir, upage, kpage, writable));
}
