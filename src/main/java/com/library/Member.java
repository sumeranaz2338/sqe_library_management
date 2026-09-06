package com.library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private String email;
    private List<String> borrowedBooks;
    private static final int BORROW_LIMIT = 3;

    public Member(String name, String memberId, String email) {
        this.name = name;
        this.memberId = memberId;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public String getEmail() { return email; }
    public List<String> getBorrowedBooks() { return borrowedBooks; }
    public static int getBorrowLimit() { return BORROW_LIMIT; }

    public void setName(String name) { this.name = name; }
    public void setMemberId(String memberId) { this.memberId = memberId; }
    public void setEmail(String email) { this.email = email; }
    public void setBorrowedBooks(List<String> borrowedBooks) { this.borrowedBooks = borrowedBooks; }

    public boolean canBorrow() {
        return borrowedBooks.size() < BORROW_LIMIT;
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s) - Borrowed: %d books", name, memberId, borrowedBooks.size());
    }
}