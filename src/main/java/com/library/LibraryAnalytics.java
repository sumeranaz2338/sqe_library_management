
package com.library;

import java.util.List;

public class LibraryAnalytics {

    private static final double MAX_PERCENTILE = 100.0;

    private LibraryAnalytics() {
        // utility class - not meant to be instantiated
    }

    /**
     * Returns the borrowing percentile of a member: the share of the OTHER members
     * who currently hold fewer books, scaled to 0-100.
     * A library with a single member returns 100.0 (nobody to compare against).
     *
     * @param member  the member being ranked
     * @param library the library whose members are compared
     * @return percentile in the range 0.0 - 100.0
     */
    public static double borrowPercentile(Member member, Library library) {
        List<Member> members = library.getAllMembers();
        int totalMembers = members.size();

        if (totalMembers <= 1) {
            return MAX_PERCENTILE;
        }

        int memberLoans = member.getBorrowedBooks().size();

        long membersWithFewerLoans = members.stream()
                .filter(other -> other.getBorrowedBooks().size() < memberLoans)
                .count();

        return (double) membersWithFewerLoans / (totalMembers - 1) * MAX_PERCENTILE;
    }
}
