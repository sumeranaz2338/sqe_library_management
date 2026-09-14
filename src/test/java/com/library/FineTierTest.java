package com.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FineTierTest {

    @Test
    void zeroDaysIsNone() {
        Library library = new Library();

        assertEquals("None", library.fineTier(0));
    }

    @Test
    void fourDaysIsLow() {
        Library library = new Library();

        assertEquals("Low", library.fineTier(4));
    }

    @Test
    void tenDaysIsMedium() {
        Library library = new Library();

        assertEquals("Medium", library.fineTier(10));
    }

    @Test
    void twentyDaysIsHigh() {
        Library library = new Library();

        assertEquals("High", library.fineTier(20));
    }

    @Test
    void fortyFiveDaysIsSevere() {
        Library library = new Library();

        assertEquals("Severe", library.fineTier(45));
    }

    @Test
    void negativeDaysAreInvalid() {
        Library library = new Library();

        assertThrows(IllegalArgumentException.class, () ->
                library.fineTier(-3)
        );
    }
}