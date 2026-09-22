package com.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Task 3: Mocking File I/O
 * 
 * Java mein mocking ke liye @TempDir use hota hai (JUnit 5).
 * Yeh sandboxed temporary directory deta hai jahan test files 
 * safely likhi ja sakti hain — production files ko touch nahi karti.
 */
public class SaveToFileTest extends RosterFixture {

    // ============= Test 1: Successful save to file (sandboxed) =============
    @Test
    void testSaveToFile_WritesExpectedContent(@TempDir Path tempDir) throws Exception {
        // Arrange
        Path filePath = tempDir.resolve("roster.txt");
        String pathString = filePath.toString();

        // Act
        roster.saveToFile(pathString);

        // Assert
        assertThat(Files.exists(filePath)).isTrue();
        String content = Files.readString(filePath);
        assertThat(content).contains("Ali");
        assertThat(content).contains("101");
        assertThat(content).contains("Sara");
        assertThat(content).contains("102");
    }

    // ============= Test 2: Failure → custom GradeBookIOError =============
    @Test
    void testSaveToFile_InvalidPath_ThrowsGradeBookIOError() {
        // Arrange: invalid path (directory doesn't exist)
        String invalidPath = "Z:/nonexistent_folder/roster.txt";

        // Act & Assert
        assertThatThrownBy(() -> roster.saveToFile(invalidPath))
            .isInstanceOf(GradeBookIOError.class)
            .hasMessageContaining("Failed to save roster")
            .hasCauseInstanceOf(IOException.class);
    }
}