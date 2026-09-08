package com.library;

import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    
    // ============ Task 2: letter_grade() ============
    public static String letterGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
    
    // ============ Task 4: validateName() ============
    public static String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("Name cannot exceed 50 characters");
        }
        if (!name.matches("^[a-zA-Z\\s\\-]+$")) {
            throw new IllegalArgumentException("Name can only contain letters, spaces, and hyphens");
        }
        return name.trim();
    }
}

// ============ Task 3: Roster Class ============
class Roster {
    private List<Integer> scores;
    
    public Roster() {
        this.scores = new ArrayList<>();
    }
    
    public void addScore(int score) {
        scores.add(score);
    }
    
    public void validateScores() {
        int count = scores.size();
        if (count < 1 || count > 6) {
            throw new IllegalArgumentException(
                "Student must have between 1 and 6 scores. Current: " + count
            );
        }
    }
    
    public List<Integer> getScores() {
        return scores;
    }
    
    public int getScoreCount() {
        return scores.size();
    }
}