package builder;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder{
    @Override
    public List<String> setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Economy");
        subjects.add("Management");
        subjects.add("Accounting");
        this.subjects = subjects;
        return subjects;
    }
}
