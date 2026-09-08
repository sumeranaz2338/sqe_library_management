package com.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"Ali Khan", "Muhammad-Ali", "John Doe"})
    void testValidNames(String name) {
        assertThat(GradeBook.validateName(name)).isEqualTo(name.trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void testEmptyName_Invalid(String name) {
        assertThatThrownBy(() -> GradeBook.validateName(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Name cannot be empty");
    }

    @Test
    void testTooLongName_Invalid() {
        String longName = "A".repeat(51);
        assertThatThrownBy(() -> GradeBook.validateName(longName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Name cannot exceed 50 characters");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ali123", "John4Doe"})
    void testNameWithDigits_Invalid(String name) {
        assertThatThrownBy(() -> GradeBook.validateName(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Name can only contain letters, spaces, and hyphens");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ali@Khan", "John#Doe"})
    void testNameWithSymbols_Invalid(String name) {
        assertThatThrownBy(() -> GradeBook.validateName(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Name can only contain letters, spaces, and hyphens");
    }
}