import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Double> scores;

    public Student() {
        scores = new ArrayList<>();

        public void addScore(double score) {
        
        public void addScore(double score) {
    if (score < 0) {
        throw new IllegalArgumentException("Score cannot be negative");
    }

    scores.add(score);
}    
        scores.add(score);

}
    }

    }