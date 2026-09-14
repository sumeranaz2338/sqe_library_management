package com.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateIsbnTest {

    @Test
    void valid13DigitIsbn() {
        Library library = new Library();

        assertTrue(library.validateIsbn("1234567890123"));
    }

    @Test
    void emptyIsbnIsInvalid() {
        Library library = new Library();

        assertFalse(library.validateIsbn(""));
    }

    @Test
    void tooShortIsbnIsInvalid() {
        Library library = new Library();

        assertFalse(library.validateIsbn("123456789"));
    }

    @Test
    void isbnContainingLettersIsInvalid() {
        Library library = new Library();

        assertFalse(library.validateIsbn("123456789012A"));
    }

    @Test
    void isbnContainingSymbolsIsInvalid() {
        Library library = new Library();

        assertFalse(library.validateIsbn("12345-6789012"));
    }
}