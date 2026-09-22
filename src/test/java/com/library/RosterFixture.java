package com.library;

import org.junit.jupiter.api.BeforeEach;

/**
 * Shared fixture for Roster tests.
 * 
 * SCOPE EXPLANATION:
 * 
 * FUNCTION SCOPE (@BeforeEach):
 * - Runs before EACH test method
 * - Fresh fixture for every test
 * - Use when: Tests modify the fixture state (add/remove items)
 * - Example: RosterFixture (below) - tests add/remove students
 * 
 * MODULE SCOPE (@BeforeAll):
 * - Runs ONCE before all tests in the class
 * - Shared across all tests (static)
 * - Use when: Setup is expensive (DB connection, file I/O) and 
 *   tests DON'T modify the fixture state
 * - Example: Loading a large config file that all tests read
 */
public class RosterFixture {

    protected Roster roster;

    @BeforeEach
    void setUp() {
        // Arrange: Create fresh Roster with 2 students
        roster = new Roster();
        
        Student s1 = new Student("Ali", 101);
        s1.addScore(80);
        s1.addScore(90);
        
        Student s2 = new Student("Sara", 102);
        s2.addScore(70);
        
        roster.addStudent(s1);
        roster.addStudent(s2);
    }
}