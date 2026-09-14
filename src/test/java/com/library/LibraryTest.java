package com.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    void memberWithThreeBooksCanBorrowAnotherBook() {
        Library library = new Library();

        library.registerMember("Ali", "M001", "ali@gmail.com");

        library.addBook("Book 1", "Author 1", "1111111111111", "General", 1);
        library.addBook("Book 2", "Author 2", "2222222222222", "General", 1);
        library.addBook("Book 3", "Author 3", "3333333333333", "General", 1);
        library.addBook("Book 4", "Author 4", "4444444444444", "General", 1);

        library.borrowBook("M001", "1111111111111");
        library.borrowBook("M001", "2222222222222");
        library.borrowBook("M001", "3333333333333");

        assertDoesNotThrow(() ->
                library.borrowBook("M001", "4444444444444")
        );
    }

    @Test
    void memberWithFiveBooksCannotBorrowSixthBook() {
        Library library = new Library();

        library.registerMember("Ali", "M001", "ali@gmail.com");

        library.addBook("Book 1", "Author 1", "1111111111111", "General", 1);
        library.addBook("Book 2", "Author 2", "2222222222222", "General", 1);
        library.addBook("Book 3", "Author 3", "3333333333333", "General", 1);
        library.addBook("Book 4", "Author 4", "4444444444444", "General", 1);
        library.addBook("Book 5", "Author 5", "5555555555555", "General", 1);
        library.addBook("Book 6", "Author 6", "6666666666666", "General", 1);

        library.borrowBook("M001", "1111111111111");
        library.borrowBook("M001", "2222222222222");
        library.borrowBook("M001", "3333333333333");
        library.borrowBook("M001", "4444444444444");
        library.borrowBook("M001", "5555555555555");

        assertThrows(IllegalArgumentException.class, () ->
                library.borrowBook("M001", "6666666666666")
        );
    }
}