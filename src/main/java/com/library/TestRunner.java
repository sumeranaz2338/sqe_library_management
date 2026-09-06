package com.library;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("TEST EXECUTION - Library Management System");
        System.out.println("============================================================");

        System.out.print("\nTC-001: ");
        try {
            Library lib = new Library();
            String result = lib.addBook("Python Programming", "John Doe", "9780132350884", "Programming", 5);
            if (result.contains("added successfully")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } catch (Exception e) {
            System.out.println("FAIL - " + e.getMessage());
        }

        System.out.print("TC-002: ");
        try {
            Library lib = new Library();
            lib.addBook("Python Programming", "John Doe", "9780132350884", "Programming", 5);
            lib.addBook("Another Book", "Jane Smith", "9780132350884", "Fiction", 3);
            System.out.println("FAIL - Exception should have been raised");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("already exists")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL - " + e.getMessage());
            }
        }

        System.out.print("TC-003: ");
        try {
            Library lib = new Library();
            lib.addBook("Test Book", "Author", "12345", "Science", 2);
            System.out.println("FAIL - Exception should have been raised");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("Invalid ISBN")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL - " + e.getMessage());
            }
        }

        System.out.print("TC-004: ");
        try {
            Library lib = new Library();
            String result = lib.registerMember("Ali Khan", "M001", "ali@email.com");
            if (result.contains("registered successfully")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } catch (Exception e) {
            System.out.println("FAIL - " + e.getMessage());
        }

        System.out.print("TC-005: ");
        try {
            Library lib = new Library();
            lib.registerMember("Ali Khan", "M001", "ali@email.com");
            lib.registerMember("Bilal Ahmed", "M001", "bilal@email.com");
            System.out.println("FAIL - Exception should have been raised");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("already exists")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL - " + e.getMessage());
            }
        }

        System.out.print("TC-006: ");
        try {
            Library lib = new Library();
            lib.addBook("Python Programming", "John Doe", "9780132350884", "Programming", 5);
            lib.registerMember("Ali Khan", "M001", "ali@email.com");
            String result = lib.borrowBook("M001", "9780132350884");
            if (result.contains("borrowed successfully")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } catch (Exception e) {
            System.out.println("FAIL - " + e.getMessage());
        }

        System.out.print("TC-007: ");
        try {
            Library lib = new Library();
            lib.addBook("Python Programming", "John Doe", "9780132350884", "Programming", 1);
            lib.registerMember("Ali Khan", "M001", "ali@email.com");
            lib.borrowBook("M001", "9780132350884");
            lib.borrowBook("M001", "9780132350884");
            System.out.println("FAIL - Exception should have been raised");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("No copies available")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL - " + e.getMessage());
            }
        }

        System.out.print("TC-008: ");
        try {
            Library lib = new Library();
            lib.addBook("Python Programming", "John Doe", "9780132350884", "Programming", 5);
            lib.registerMember("Ali Khan", "M001", "ali@email.com");
            lib.borrowBook("M001", "9780132350884");
            String result = lib.returnBook("M001", "9780132350884");
            if (result.contains("returned successfully")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } catch (Exception e) {
            System.out.println("FAIL - " + e.getMessage());
        }

        System.out.print("TC-009: ");
        try {
            Library lib = new Library();
            lib.addBook("Python Programming", "John Doe", "9780132350884", "Programming", 5);
            lib.registerMember("Ali Khan", "M001", "ali@email.com");
            lib.returnBook("M001", "9780132350884");
            System.out.println("FAIL - Exception should have been raised");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("not borrowed")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL - " + e.getMessage());
            }
        }

        System.out.print("TC-010: ");
        try {
            Library lib = new Library();
            lib.addBook("Book1", "Author1", "111-1111", "Fiction", 2);
            lib.addBook("Book2", "Author2", "222-2222", "Non-Fiction", 2);
            lib.addBook("Book3", "Author3", "333-3333", "Science", 2);
            lib.registerMember("Test", "T001", "test@email.com");
            lib.borrowBook("T001", "111-1111");
            lib.borrowBook("T001", "222-2222");
            String result = lib.borrowBook("T001", "333-3333");
            if (result.contains("borrowed successfully")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } catch (Exception e) {
            System.out.println("FAIL - " + e.getMessage());
        }

        System.out.print("TC-011: ");
        try {
            Library lib = new Library();
            lib.addBook("Book1", "Author1", "111-1111", "Fiction", 2);
            lib.addBook("Book2", "Author2", "222-2222", "Non-Fiction", 2);
            lib.addBook("Book3", "Author3", "333-3333", "Science", 2);
            lib.addBook("Book4", "Author4", "444-4444", "History", 2);
            lib.registerMember("Test", "T001", "test@email.com");
            lib.borrowBook("T001", "111-1111");
            lib.borrowBook("T001", "222-2222");
            lib.borrowBook("T001", "333-3333");
            lib.borrowBook("T001", "444-4444");
            System.out.println("FAIL - Exception should have been raised");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("borrowing limit")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL - " + e.getMessage());
            }
        }

        System.out.print("TC-012: ");
        try {
            Library lib = new Library();
            lib.addBook("Python Programming", "John Doe", "9780132350884", "Programming", 5);
            lib.addBook("Java Programming", "Jane Smith", "9780132350885", "Programming", 3);
            var results = lib.searchBooks("Python");
            if (results.size() == 1 && results.get(0).getTitle().equals("Python Programming")) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL - Expected 1 result, got " + results.size());
            }
        } catch (Exception e) {
            System.out.println("FAIL - " + e.getMessage());
        }

        System.out.println("\n============================================================");
        System.out.println("TEST EXECUTION COMPLETE");
        System.out.println("============================================================");
    }
}