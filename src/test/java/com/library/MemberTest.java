package com.library;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    void borrowLimitIsFive() {
        assertThat(Member.getBorrowLimit()).isEqualTo(5);
    }

    @Test
    void canBorrow_BoundaryAtFourAndFiveBooks() {
        Member m = new Member("Ali", "M001", "ali@gmail.com");
        for (int i = 0; i < 4; i++) m.getBorrowedBooks().add("isbn" + i);
        assertThat(m.canBorrow()).isTrue();
        m.getBorrowedBooks().add("isbn4");
        assertThat(m.canBorrow()).isFalse();
    }

    @Test
    void settersUpdateEveryField() {
        Member m = new Member("Ali", "M001", "ali@gmail.com");
        List<String> loans = new ArrayList<>(List.of("x"));
        m.setName("Sara"); m.setMemberId("M002"); m.setEmail("s@x.com"); m.setBorrowedBooks(loans);
        assertThat(m.getName()).isEqualTo("Sara");
        assertThat(m.getMemberId()).isEqualTo("M002");
        assertThat(m.getEmail()).isEqualTo("s@x.com");
        assertThat(m.getBorrowedBooks()).containsExactly("x");
    }

    @Test
    void toString_ShowsNameIdAndLoanCount() {
        assertThat(new Member("Ali", "M001", "a@b.com").toString())
                .isEqualTo("Ali (ID: M001) - Borrowed: 0 books");
    }
}
