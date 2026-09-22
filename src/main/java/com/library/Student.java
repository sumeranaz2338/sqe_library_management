package com.library;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private int rollNo;
    private List<Integer> scores;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.scores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public List<Integer> getScores() {
        return scores;
    }

    /**
     * Adds a non-negative score to the student's scores.
     *
     * @param score the score to add
     * @throws IllegalArgumentException if the score is negative
     */
    public void addScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        }
        scores.add(score);
    }

    /**
     * Calculates the average of all scores.
     *
     * @return average score, or 0.0 if no scores exist
     */
    public double average() {
        if (scores.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }
}