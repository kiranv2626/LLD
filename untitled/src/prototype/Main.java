package prototype;

public class Main {
    public static void main(String[] args) {
        Student prototype = new Student(1, "rohit", "rohit@123");
        Student prototype1 = (Student)prototype.Clone();
        System.out.println(prototype1.getName());
    }
}
