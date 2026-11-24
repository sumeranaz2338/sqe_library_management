package com.library;
 
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
 
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
 
    private static Library libraryWithLoans() {
        Library library = new Library();
        library.registerMember("Ali", "M001", "ali@gmail.com");
        library.registerMember("Sara", "M002", "sara@gmail.com");
        library.registerMember("Bilal", "M003", "bilal@gmail.com");
        library.addBook("Book 1", "A", "1111111111111", "General", 5);
        library.addBook("Book 2", "A", "2222222222222", "General", 5);
        library.borrowBook("M003", "1111111111111");
        library.borrowBook("M003", "2222222222222");
        library.borrowBook("M002", "1111111111111");
        return library;
    }
 
    private static Member member(Library library, String id) {
        return library.getAllMembers().stream()
                .filter(m -> m.getMemberId().equals(id)).findFirst().orElseThrow();
    }
 
    @Test
    void topBorrowerIsHundredthPercentile() {
        Library library = libraryWithLoans();
        assertThat(LibraryAnalytics.borrowPercentile(member(library, "M003"), library)).isEqualTo(100.0);
    }
 
    @Test
    void middleBorrowerIsFiftiethPercentile() {
        Library library = libraryWithLoans();
        assertThat(LibraryAnalytics.borrowPercentile(member(library, "M002"), library)).isEqualTo(50.0);
    }
 
    @Test
    void singleMemberLibraryReturnsHundred() {
        Library library = new Library();
        library.registerMember("Ali", "M001", "ali@gmail.com");
        assertThat(LibraryAnalytics.borrowPercentile(member(library, "M001"), library)).isEqualTo(100.0);
    }
    @Test
void emptyLibraryThrowsIllegalArgumentException() {
    Library library = new Library();
    library.registerMember("Ali", "M001", "ali@gmail.com");

    Library emptyLibrary = new Library();
    Member ali = member(library, "M001");

    assertThatThrownBy(() ->
            LibraryAnalytics.borrowPercentile(ali, emptyLibrary))
            .isInstanceOf(IllegalArgumentException.class);
}

@Test
void unregisteredMemberThrowsIllegalArgumentException() {
    Library library = new Library();
    library.registerMember("Ali", "M001", "ali@gmail.com");

    Library anotherLibrary = new Library();
    anotherLibrary.registerMember("Sara", "M002", "sara@gmail.com");

    Member sara = member(anotherLibrary, "M002");

    assertThatThrownBy(() ->
            LibraryAnalytics.borrowPercentile(sara, library))
            .isInstanceOf(IllegalArgumentException.class);
}
}