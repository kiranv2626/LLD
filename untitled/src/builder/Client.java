package builder;

import vending.DispenseItemState;

public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MBAStudentBuilder());
        Student s1=director.createStudent();
        System.out.println("MBA Student: " + s1.toString());;


        director = new Director(new EngineerStudentBuilder());
        Student s2=director.createStudent();
        System.out.println("Engineer Student: " + s2.toString());
    }
}
