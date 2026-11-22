package com.library;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GradeBookIOErrorTest {

    @Test
    void messageOnlyConstructorKeepsMessageAndHasNoCause() {
        GradeBookIOError e = new GradeBookIOError("disk full");
        assertThat(e).hasMessage("disk full");
        assertThat(e.getCause()).isNull();
    }

    @Test
    void saveToFile_PathIsADirectory_ThrowsGradeBookIOErrorWithCause() {
        Roster roster = new Roster();
        String dir = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        assertThatThrownBy(() -> roster.saveToFile(dir))
                .isInstanceOf(GradeBookIOError.class)
                .hasMessageContaining("Failed to save roster to file")
                .hasCauseInstanceOf(java.io.IOException.class);
    }
}
