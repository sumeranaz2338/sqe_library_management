package com.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateNameBvaTest {

    // ========== Lower edge (0 chars) ==========
    @Test
    void testLowerEdge_0Chars_Invalid() {
        assertThatThrownBy(() -> GradeBook.validateName(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testLowerEdge_1Char_Valid() {
        assertThat(GradeBook.validateName("A")).isEqualTo("A");
    }

    @Test
    void testLowerEdge_2Chars_Valid() {
        assertThat(GradeBook.validateName("Al")).isEqualTo("Al");
    }

    // ========== Upper edge (50 chars) ==========
    @Test
    void testUpperEdge_49Chars_Valid() {
        String name49 = "A".repeat(49);
        assertThat(GradeBook.validateName(name49)).isEqualTo(name49);
    }

    @Test
    void testUpperEdge_50Chars_Valid() {
        String name50 = "A".repeat(50);
        assertThat(GradeBook.validateName(name50)).isEqualTo(name50);
    }

    @Test
    void testUpperEdge_51Chars_Invalid() {
        String name51 = "A".repeat(51);
        assertThatThrownBy(() -> GradeBook.validateName(name51))
            .isInstanceOf(IllegalArgumentException.class);
    }
}