package com.library;

public class GradeBook {
    
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