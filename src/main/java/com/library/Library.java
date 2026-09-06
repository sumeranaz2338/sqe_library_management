package com.library;

import java.util.*;

public class Library {
    private Map<String, Book> books;
    private Map<String, Member> members;
    private Map<String, List<String>> borrowedBooks;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
    }

    public String addBook(String title, String author, String isbn, String category, int copies) {
        if (isbn == null || isbn.length() < 10) {
            throw new IllegalArgumentException("Invalid ISBN format");
        }
        if (books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " already exists");
        }
        if (copies < 0) {
            throw new IllegalArgumentException("Copies cannot be negative");
        }
        Book book = new Book(title, author, isbn, category, copies);
        books.put(isbn, book);
        return "Book '" + title + "' added successfully with " + copies + " copies";
    }

    public String registerMember(String name, String memberId, String email) {
        if (members.containsKey(memberId)) {
            throw new IllegalArgumentException("Member ID " + memberId + " already exists");
        }
        Member member = new Member(name, memberId, email);
        members.put(memberId, member);
        borrowedBooks.put(memberId, new ArrayList<>());
        return "Member '" + name + "' registered successfully";
    }

    public String borrowBook(String memberId, String isbn) {
        if (!members.containsKey(memberId)) {
            throw new IllegalArgumentException("Member ID " + memberId + " not found");
        }
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found");
        }
        Member member = members.get(memberId);
        Book book = books.get(isbn);
        if (!member.canBorrow()) {
            throw new IllegalArgumentException("Member has reached borrowing limit of " + Member.getBorrowLimit() + " books");
        }
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("No copies available for this book");
        }
        if (borrowedBooks.get(memberId).contains(isbn)) {
            throw new IllegalArgumentException("Member already borrowed this book");
        }
        book.setCopies(book.getCopies() - 1);
        book.getBorrowedBy().add(memberId);
        borrowedBooks.get(memberId).add(isbn);
        member.getBorrowedBooks().add(isbn);
        return "Book '" + book.getTitle() + "' borrowed successfully";
    }

    public String returnBook(String memberId, String isbn) {
        if (!members.containsKey(memberId)) {
            throw new IllegalArgumentException("Member ID " + memberId + " not found");
        }
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found");
        }
        if (!borrowedBooks.get(memberId).contains(isbn)) {
            throw new IllegalArgumentException("This book was not borrowed by this member");
        }
        Book book = books.get(isbn);
        book.setCopies(book.getCopies() + 1);
        book.getBorrowedBy().remove(memberId);
        borrowedBooks.get(memberId).remove(isbn);
        members.get(memberId).getBorrowedBooks().remove(isbn);
        return "Book '" + book.getTitle() + "' returned successfully";
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(lowerQuery) ||
                book.getAuthor().toLowerCase().contains(lowerQuery) ||
                book.getIsbn().toLowerCase().contains(lowerQuery)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }
}