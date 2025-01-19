package builder;

public class Director {
    StudentBuilder studentBuilder;
    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if (studentBuilder instanceof EngineerStudentBuilder) {
            return createEngineeringStudent();
        } else if (studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    public Student createEngineeringStudent() {
        studentBuilder.setRollNo(1);
        studentBuilder.setName("John");
        studentBuilder.setFatherName("Doe");
        studentBuilder.setMotherName("Jane");
        studentBuilder.setSubjects();
        return studentBuilder.build();
    }

    public Student createMBAStudent() {
        studentBuilder.setRollNo(1);
        studentBuilder.setName("Hello");
        studentBuilder.setFatherName("World");
        studentBuilder.setMotherName("Computer");
        studentBuilder.setSubjects();
        return studentBuilder.build();
    }

}
