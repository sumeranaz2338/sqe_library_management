import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeBook {
    private Map<Integer, Student> students;

    public GradeBook() {
        students = new HashMap<>();
    }

    public void addStudent(String name, int rollNumber) {
        if (students.containsKey(rollNumber)) {
            throw new IllegalArgumentException("Student with roll number " + rollNumber + " already exists");
        }
        Student student = new Student();
        // Note: Student class currently doesn't have name field
        students.put(rollNumber, student);
    }

    public Student findStudent(int rollNumber) {
        return students.get(rollNumber);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
}