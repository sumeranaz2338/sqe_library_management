package com.library;

public class GradeBook {
    private static final int GRADE_A_MIN = 90;
    private static final int GRADE_B_MIN = 80;
    private static final int GRADE_C_MIN = 70;
    private static final int GRADE_D_MIN = 60;
    private static final int MAX_SCORE = 100;
    private static final int MAX_NAME_LENGTH = 50;

        private GradeBook() {
        // static utility class - no instances
    }
    
    public static String letterGrade(int score) {
        if (score < 0 || score > MAX_SCORE) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (score >= GRADE_A_MIN) return "A";
        if (score >= GRADE_B_MIN) return "B";
        if (score >= GRADE_C_MIN) return "C";
        if (score >= GRADE_D_MIN) return "D";
        return "F";
    }
    
    public static String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name cannot exceed 50 characters");
        }
        if (!name.matches("^[a-zA-Z\\s\\-]+$")) {
            throw new IllegalArgumentException("Name can only contain letters, spaces, and hyphens");
        }
        return name.trim();
    }
}