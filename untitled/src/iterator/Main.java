package iterator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(100,"Book1"));
        books.add(new Book(200,"Book2"));
        books.add(new Book(300,"Book3"));
        books.add(new Book(400,"Book4"));
        Library library = new Library(books);
        Iterator bookIteratoor = library.createIterator();
        while(bookIteratoor.hasNext()){
           Book book = (Book)bookIteratoor.next();
           System.out.println(book.getName());
        }
    }


}
