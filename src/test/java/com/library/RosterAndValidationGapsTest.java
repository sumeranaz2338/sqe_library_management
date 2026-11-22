package com.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/** Lab 11 - last few untested branches found in the HTML report. */
class RosterAndValidationGapsTest {

    @Test
    void addStudent_DuplicateRollNumber_Throws() {
        Roster roster = new Roster();
        roster.addStudent(new Student("Ali", 101));
        assertThatThrownBy(() -> roster.addStudent(new Student("Sara", 101)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Student with roll number 101 already exists");
        assertThat(roster.getStudentCount()).isEqualTo(1);
    }

    @Test
    void findStudent_UnknownRollNumber_ReturnsNull() {
        assertThat(new Roster().findStudent(999)).isNull();
    }

    @Test
    void validateIsbn_NullIsFalse_AndShortIsbnRejectedByAddBook() {
        Library library = new Library();
        assertThat(library.validateIsbn(null)).isFalse();
        assertThatThrownBy(() -> library.addBook("T", "A", "12345", "C", 1))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Invalid ISBN format");
    }

    @Test
    void validateName_RejectsDigitsAndSymbols() {
        assertThatThrownBy(() -> GradeBook.validateName("Ali123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name can only contain letters, spaces, and hyphens");
    }
}
