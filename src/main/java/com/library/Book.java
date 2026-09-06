package com.library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String category;
    private int copies;
    private List<String> borrowedBy;

    public Book(String title, String author, String isbn, String category, int copies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.copies = copies;
        this.borrowedBy = new ArrayList<>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getCategory() { return category; }
    public int getCopies() { return copies; }
    public List<String> getBorrowedBy() { return borrowedBy; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setCategory(String category) { this.category = category; }
    public void setCopies(int copies) { this.copies = copies; }
    public void setBorrowedBy(List<String> borrowedBy) { this.borrowedBy = borrowedBy; }

    public boolean isAvailable() {
        return copies > 0;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (ISBN: %s) - %d copies", title, author, isbn, copies);
    }
}