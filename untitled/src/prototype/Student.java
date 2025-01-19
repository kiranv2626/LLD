package prototype;

public class Student implements Prototype{
    private int rollNo;
    String name;
    String Email;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    Student(int rollNo, String name, String Email){
        this.rollNo=rollNo;
        this.name=name;
        this.Email=Email;
    }
    @Override
    public Prototype Clone(){
        return new Student(rollNo,name,Email);
    }
}
