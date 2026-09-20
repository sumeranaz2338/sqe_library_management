package com.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RosterBvaTest {

    // ========== Lower edge (1 score) ==========
    @Test
    void testLowerEdge_0Scores_Invalid() {
        Roster roster = new Roster();
        assertThatThrownBy(() -> roster.validateScores())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testLowerEdge_1Score_Valid() {
        Roster roster = new Roster();
        roster.addScore(85);
        roster.validateScores();
        assertThat(roster.getScoreCount()).isEqualTo(1);
    }

    @Test
    void testLowerEdge_2Scores_Valid() {
        Roster roster = new Roster();
        roster.addScore(85);
        roster.addScore(90);
        roster.validateScores();
        assertThat(roster.getScoreCount()).isEqualTo(2);
    }

    // ========== Upper edge (6 scores) ==========
    @Test
    void testUpperEdge_5Scores_Valid() {
        Roster roster = new Roster();
        for (int i = 0; i < 5; i++) {
            roster.addScore(70 + i);
        }
        roster.validateScores();
        assertThat(roster.getScoreCount()).isEqualTo(5);
    }

    @Test
    void testUpperEdge_6Scores_Valid() {
        Roster roster = new Roster();
        for (int i = 0; i < 6; i++) {
            roster.addScore(70 + i);
        }
        roster.validateScores();
        assertThat(roster.getScoreCount()).isEqualTo(6);
    }

    @Test
    void testUpperEdge_7Scores_Invalid() {
        Roster roster = new Roster();
        for (int i = 0; i < 7; i++) {
            roster.addScore(70 + i);
        }
        assertThatThrownBy(() -> roster.validateScores())
            .isInstanceOf(IllegalArgumentException.class);
    }
}