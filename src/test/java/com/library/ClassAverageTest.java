package com.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * Task 2: Test class_average() with fixture pattern
 * 3 tests: empty roster, single student, multiple students
 */
public class ClassAverageTest extends RosterFixture {

    // Test 1: Empty roster → 0.0
    @Test
    void testClassAverage_EmptyRoster_ReturnsZero() {
        // Arrange
        Roster emptyRoster = new Roster();

        // Act
        double result = emptyRoster.classAverage();

        // Assert
        assertThat(result).isEqualTo(0.0);
    }

    // Test 2: Single student → their average
    @Test
    void testClassAverage_SingleStudent() {
        // Arrange
        Roster singleRoster = new Roster();
        Student s = new Student("Ali", 101);
        s.addScore(80);
        s.addScore(90);
        singleRoster.addStudent(s);

        // Act
        double result = singleRoster.classAverage();

        // Assert: Ali's average = (80 + 90) / 2 = 85.0
        assertThat(result).isCloseTo(85.0, within(0.01));
    }

    // Test 3: Multiple students → average of averages (using fixture)
    @Test
    void testClassAverage_MultipleStudents() {
        // Arrange: fixture has Ali (80,90 → 85.0) and Sara (70 → 70.0)
        // Expected: (85 + 70) / 2 = 77.5

        // Act
        double result = roster.classAverage();

        // Assert
        assertThat(result).isCloseTo(77.5, within(0.01));
    }
}