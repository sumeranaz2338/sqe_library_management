package com.library;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Task 4: Parametrized Edge-Case Sweep for addScore()
 * 
 * Consolidates 6+ previously-separate single-purpose tests into 
 * parametrized tests. Each test case is documented via the name attribute.
 */
public class AddScoreParametrizedTest {

    // ============ Valid scores - consolidated ============
    @ParameterizedTest(name = "addScore({0}) should succeed")
    @ValueSource(ints = {0, 50, 75, 100})
    void testAddScore_ValidScores(int score) {
        // Arrange
        Student s = new Student("Ali", 101);

        // Act
        s.addScore(score);

        // Assert
        assertThat(s.getScores()).containsExactly(score);
    }

    // ============ Negative scores - consolidated ============
    @ParameterizedTest(name = "addScore({0}) should throw exception")
    @ValueSource(ints = {-1, -50, -100})
    void testAddScore_NegativeScores(int score) {
        // Arrange
        Student s = new Student("Ali", 101);

        // Act & Assert
        assertThatThrownBy(() -> s.addScore(score))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Score cannot be negative");
    }

    // ============ Multiple scores - CSV parametrized ============
    @ParameterizedTest(name = "add scores {0},{1},{2} → avg {3}")
    @CsvSource({
        "80, 90, 70, 80.0",
        "100, 100, 100, 100.0",
        "0, 0, 0, 0.0",
        "50, 60, 70, 60.0"
    })
    void testAddMultipleScores_Average(int s1, int s2, int s3, double expectedAvg) {
        // Arrange
        Student s = new Student("Ali", 101);

        // Act
        s.addScore(s1);
        s.addScore(s2);
        s.addScore(s3);

        // Assert
        assertThat(s.average()).isEqualTo(expectedAvg);
    }
}