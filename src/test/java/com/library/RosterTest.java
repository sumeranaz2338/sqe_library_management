package com.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RosterTest {

    // C8: 0 scores - Invalid
    @Test
    void testZeroScores_Invalid() {
        Roster roster = new Roster();
        assertThatThrownBy(() -> roster.validateScores())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("between 1 and 6 scores");
    }

    // C9: 3 scores - Valid
    @Test
    void testThreeScores_Valid() {
        Roster roster = new Roster();
        roster.addScore(85);
        roster.addScore(90);
        roster.addScore(78);
        roster.validateScores();
        assertThat(roster.getScoreCount()).isEqualTo(3);
    }

    // C10: 8 scores - Invalid
    @Test
    void testEightScores_Invalid() {
        Roster roster = new Roster();
        for (int i = 0; i < 8; i++) {
            roster.addScore(70 + i);
        }
        assertThatThrownBy(() -> roster.validateScores())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("between 1 and 6 scores");
    }
}