import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Double> gradeList;      

    public Student() {
        gradeList = new ArrayList<>();  
    }

    /**
     * Adds a non-negative score to the student's scores.
     *
     * @param studentScore the score to add
     * @throws IllegalArgumentException if the score is negative
     */
    public void addScore(double studentScore) {
        if (studentScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        }

       gradeList.add(studentScore);    
    }
}