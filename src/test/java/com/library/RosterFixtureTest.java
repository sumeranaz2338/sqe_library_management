package com.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Task 1: Fixture Refactor
 * Refactored 4 tests to use shared fixture (RosterFixture).
 */
public class RosterFixtureTest extends RosterFixture {

    // Test 1: Roster has 2 students (from fixture)
    @Test
    void testRosterHasTwoStudents() {
        assertThat(roster.getStudentCount()).isEqualTo(2);
    }

    // Test 2: Ali has 2 scores (from fixture)
    @Test
    void testAliScoreCount() {
        Student ali = roster.findStudent(101);
        assertThat(ali).isNotNull();
        assertThat(ali.getScores()).hasSize(2);
    }

    // Test 3: Sara has 1 score (from fixture)
    @Test
    void testSaraScoreCount() {
        Student sara = roster.findStudent(102);
        assertThat(sara).isNotNull();
        assertThat(sara.getScores()).hasSize(1);
    }

    // Test 4: Add student works
    @Test
    void testAddStudent() {
        Student s3 = new Student("Bilal", 103);
        s3.addScore(85);
        roster.addStudent(s3);
        assertThat(roster.getStudentCount()).isEqualTo(3);
        assertThat(roster.findStudent(103)).isNotNull();
    }
}