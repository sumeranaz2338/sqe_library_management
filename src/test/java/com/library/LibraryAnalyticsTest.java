package com.library;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LibraryAnalyticsTest {

    @Test
    void memberWithFewestLoansIsZeroPercentile() {
        Library library = new Library();
        library.registerMember("Ali", "M001", "ali@gmail.com");
        library.registerMember("Sara", "M002", "sara@gmail.com");
        library.registerMember("Bilal", "M003", "bilal@gmail.com");
        library.addBook("Book 1", "A", "1111111111111", "General", 5);
        library.borrowBook("M002", "1111111111111");

        Member ali = library.getAllMembers().stream()
                .filter(x -> x.getMemberId().equals("M001")).findFirst().get();

        assertThat(LibraryAnalytics.borrowPercentile(ali, library)).isEqualTo(0.0);
    }
}