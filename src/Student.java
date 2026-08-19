import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Double> studentScores;

    public Student() {
        studentScores = new ArrayList<>();   
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

        studentScores.add(studentScore);     
    }
}