package com.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LetterGradeBvaTest {

    // ========== Lower domain edge (0) ==========
    @Test
    void testLowerEdge_Minus1_Invalid() {
        assertThatThrownBy(() -> GradeBook.letterGrade(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testLowerEdge_0_F() {
        assertThat(GradeBook.letterGrade(0)).isEqualTo("F");
    }

    @Test
    void testLowerEdge_1_F() {
        assertThat(GradeBook.letterGrade(1)).isEqualTo("F");
    }

    // ========== F/D cut-off (60) ==========
    @Test
    void testCutoff60_59_F() {
        assertThat(GradeBook.letterGrade(59)).isEqualTo("F");
    }

    @Test
    void testCutoff60_60_D() {
        assertThat(GradeBook.letterGrade(60)).isEqualTo("D");
    }

    @Test
    void testCutoff60_61_D() {
        assertThat(GradeBook.letterGrade(61)).isEqualTo("D");
    }

    // ========== D/C cut-off (70) ==========
    @Test
    void testCutoff70_69_D() {
        assertThat(GradeBook.letterGrade(69)).isEqualTo("D");
    }

    @Test
    void testCutoff70_70_C() {
        assertThat(GradeBook.letterGrade(70)).isEqualTo("C");
    }

    @Test
    void testCutoff70_71_C() {
        assertThat(GradeBook.letterGrade(71)).isEqualTo("C");
    }

    // ========== C/B cut-off (80) ==========
    @Test
    void testCutoff80_79_C() {
        assertThat(GradeBook.letterGrade(79)).isEqualTo("C");
    }

    @Test
    void testCutoff80_80_B() {
        assertThat(GradeBook.letterGrade(80)).isEqualTo("B");
    }

    @Test
    void testCutoff80_81_B() {
        assertThat(GradeBook.letterGrade(81)).isEqualTo("B");
    }

    // ========== B/A cut-off (90) ==========
    @Test
    void testCutoff90_89_B() {
        assertThat(GradeBook.letterGrade(89)).isEqualTo("B");
    }

    @Test
    void testCutoff90_90_A() {
        assertThat(GradeBook.letterGrade(90)).isEqualTo("A");
    }

    @Test
    void testCutoff90_91_A() {
        assertThat(GradeBook.letterGrade(91)).isEqualTo("A");
    }

    // ========== Upper domain edge (100) ==========
    @Test
    void testUpperEdge_99_A() {
        assertThat(GradeBook.letterGrade(99)).isEqualTo("A");
    }

    @Test
    void testUpperEdge_100_A() {
        assertThat(GradeBook.letterGrade(100)).isEqualTo("A");
    }

    @Test
    void testUpperEdge_101_Invalid() {
        assertThatThrownBy(() -> GradeBook.letterGrade(101))
            .isInstanceOf(IllegalArgumentException.class);
    }
}