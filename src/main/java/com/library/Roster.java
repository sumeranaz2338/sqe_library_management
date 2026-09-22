package com.library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Roster {
    private List<Student> students;

    public Roster() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getRollNo() == student.getRollNo()) {
                throw new IllegalArgumentException(
                    "Student with roll number " + student.getRollNo() + " already exists"
                );
            }
        }
        students.add(student);
    }

    public Student findStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public double classAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Student s : students) {
            total += s.average();
        }
        return total / students.size();
    }

    public void saveToFile(String path) throws GradeBookIOError {
        StringBuilder content = new StringBuilder();
        for (Student s : students) {
            content.append(s.getName()).append(",")
                   .append(s.getRollNo()).append(",")
                   .append(s.average()).append("\n");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content.toString());
        } catch (IOException e) {
            throw new GradeBookIOError("Failed to save roster to file: " + path, e);
        }
    }
}