package com.library;

public class GradeBookIOError extends Exception {
    public GradeBookIOError(String message, Throwable cause) {
        super(message, cause);
    }

    public GradeBookIOError(String message) {
        super(message);
    }
}