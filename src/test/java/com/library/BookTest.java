package com.library;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class BookTest {

    private static Book sample(int copies) {
        return new Book("Clean Code", "Robert Martin", "1111111111111", "Programming", copies);
    }

    @Test
    void isAvailable_TrueWhenCopiesRemain_FalseAtZero() {
        assertThat(sample(1).isAvailable()).isTrue();
        assertThat(sample(0).isAvailable()).isFalse();
    }

    @Test
    void settersUpdateEveryField() {
        Book b = sample(1);
        List<String> who = new ArrayList<>(List.of("M001"));
        b.setTitle("T"); b.setAuthor("A"); b.setIsbn("2222222222222");
        b.setCategory("C"); b.setCopies(7); b.setBorrowedBy(who);

        assertThat(b.getTitle()).isEqualTo("T");
        assertThat(b.getAuthor()).isEqualTo("A");
        assertThat(b.getIsbn()).isEqualTo("2222222222222");
        assertThat(b.getCategory()).isEqualTo("C");
        assertThat(b.getCopies()).isEqualTo(7);
        assertThat(b.getBorrowedBy()).containsExactly("M001");
    }

    @Test
    void toString_ContainsTitleAuthorIsbnAndCopies() {
        assertThat(sample(3).toString())
                .isEqualTo("Clean Code by Robert Martin (ISBN: 1111111111111) - 3 copies");
    }
}
