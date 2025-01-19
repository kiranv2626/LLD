package builder;

import java.util.List;

public abstract class StudentBuilder {
    int rollNo;
    String Name;
    int age;
    String FatherName;
    String MotherName;
    List<String> subjects;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public abstract List<String> setSubjects() ;

    public Student build(){
        return new Student(this);
    }
}
