import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Double> studentMarks;

    public Student() {
        studentMarks = new ArrayList<>();
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
        studentMarks.add(studentScore);
    }

    /**
     * Calculates the average of all scores.
     *
     * @return average score, or 0.0 if no scores exist
     */
    public double average() {
        if (studentMarks.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double score : studentMarks) {
            sum += score;
        }
        return sum / studentMarks.size();
    }
}