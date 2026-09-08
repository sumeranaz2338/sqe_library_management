package com.library;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LetterGradeTest {

    @ParameterizedTest
    @CsvSource({
        "45, F",
        "65, D", 
        "75, C",
        "85, B",
        "95, A"
    })
    void testValidClasses(int score, String expected) {
        assertThat(GradeBook.letterGrade(score)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 150})
    void testInvalidClasses(int score) {
        assertThatThrownBy(() -> GradeBook.letterGrade(score))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Score must be between 0 and 100");
    }
}