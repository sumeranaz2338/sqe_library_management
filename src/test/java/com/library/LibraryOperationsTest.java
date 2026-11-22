package com.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/** Lab 11 - closes the coverage gaps found in Library.java (error branches first). */
class LibraryOperationsTest {

    private static final String ISBN_1 = "1111111111111";
    private static final String ISBN_2 = "2222222222222";

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
        library.registerMember("Ali", "M001", "ali@gmail.com");
        library.addBook("Clean Code", "Robert Martin", ISBN_1, "Programming", 2);
    }

    // ---------- addBook ----------
    @Test
    void addBook_ValidBook_ReturnsSuccessMessage() {
        String msg = library.addBook("Refactoring", "Martin Fowler", ISBN_2, "Programming", 3);
        assertThat(msg).isEqualTo("Book 'Refactoring' added successfully with 3 copies");
        assertThat(library.getAllBooks()).hasSize(2);
    }

    @Test
    void addBook_NullIsbn_Throws() {
        assertThatThrownBy(() -> library.addBook("X", "Y", null, "Z", 1))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Invalid ISBN format");
    }

    @Test
    void addBook_DuplicateIsbn_Throws() {
        assertThatThrownBy(() -> library.addBook("Other", "Someone", ISBN_1, "Z", 1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("already exists");
    }

    @Test
    void addBook_NegativeCopies_Throws() {
        assertThatThrownBy(() -> library.addBook("Other", "Someone", ISBN_2, "Z", -1))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Copies cannot be negative");
    }

    // ---------- registerMember ----------
    @Test
    void registerMember_Duplicate_Throws() {
        assertThatThrownBy(() -> library.registerMember("Sara", "M001", "sara@gmail.com"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("already exists");
    }

    @Test
    void registerMember_Valid_AppearsInMemberList() {
        String msg = library.registerMember("Sara", "M002", "sara@gmail.com");
        assertThat(msg).contains("registered successfully");
        assertThat(library.getAllMembers()).hasSize(2);
    }

    // ---------- borrowBook ----------
    @Test
    void borrowBook_Valid_DecrementsCopiesAndTracksLoan() {
        String msg = library.borrowBook("M001", ISBN_1);

        assertThat(msg).isEqualTo("Book 'Clean Code' borrowed successfully");
        Book book = library.getAllBooks().get(0);
        assertThat(book.getCopies()).isEqualTo(1);
        assertThat(book.getBorrowedBy()).containsExactly("M001");
        assertThat(library.getAllMembers().get(0).getBorrowedBooks()).containsExactly(ISBN_1);
    }

    @Test
    void borrowBook_UnknownMember_Throws() {
        assertThatThrownBy(() -> library.borrowBook("M999", ISBN_1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("not found");
    }

    @Test
    void borrowBook_UnknownBook_Throws() {
        assertThatThrownBy(() -> library.borrowBook("M001", "0000000000000"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("not found");
    }

    @Test
    void borrowBook_NoCopiesLeft_Throws() {
        library.addBook("Rare", "Anon", ISBN_2, "History", 0);
        assertThatThrownBy(() -> library.borrowBook("M001", ISBN_2))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("No copies available for this book");
    }

    @Test
    void borrowBook_SameBookTwice_Throws() {
        library.borrowBook("M001", ISBN_1);
        assertThatThrownBy(() -> library.borrowBook("M001", ISBN_1))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Member already borrowed this book");
    }

    // ---------- returnBook ----------
    @Test
    void returnBook_Valid_RestoresCopyAndClearsLoan() {
        library.borrowBook("M001", ISBN_1);

        String msg = library.returnBook("M001", ISBN_1);

        assertThat(msg).isEqualTo("Book 'Clean Code' returned successfully");
        Book book = library.getAllBooks().get(0);
        assertThat(book.getCopies()).isEqualTo(2);
        assertThat(book.getBorrowedBy()).isEmpty();
        assertThat(library.getAllMembers().get(0).getBorrowedBooks()).isEmpty();
    }

    @Test
    void returnBook_UnknownMember_Throws() {
        assertThatThrownBy(() -> library.returnBook("M999", ISBN_1))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Member ID M999 not found");
    }

    @Test
    void returnBook_UnknownBook_Throws() {
        assertThatThrownBy(() -> library.returnBook("M001", "0000000000000"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("not found");
    }

    @Test
    void returnBook_NotBorrowedByMember_Throws() {
        assertThatThrownBy(() -> library.returnBook("M001", ISBN_1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This book was not borrowed by this member");
    }

    // ---------- searchBooks ----------
    @Test
    void searchBooks_ByTitleAuthorOrIsbn_IsCaseInsensitive() {
        assertThat(library.searchBooks("CLEAN")).hasSize(1);
        assertThat(library.searchBooks("martin")).hasSize(1);
        assertThat(library.searchBooks("1111")).hasSize(1);
    }

    @Test
    void searchBooks_NoMatch_ReturnsEmptyList() {
        assertThat(library.searchBooks("zzz")).isEmpty();
    }
}
