package builder;

import java.util.List;

public class Student {
    int rollNo;
    String Name;
    int age;
    String FatherName;
    String MotherName;
    List<String> subjects;

    public Student(StudentBuilder studentBuilder) {
        this.rollNo = studentBuilder.rollNo;
        this.Name = studentBuilder.Name;
        this.age = studentBuilder.age;
        this.FatherName = studentBuilder.FatherName;
        this.MotherName = studentBuilder.MotherName;
        this.subjects = studentBuilder.subjects;
    }

    public String toString() {
        return "Student [rollNo=" + rollNo + ", Name=" + Name + ", age=" + age
                + ", FatherName=" + FatherName + ", MotherName=" + MotherName
                + ", subjects=" + subjects + "]";
    }
}
