
package com.library;

import java.util.List;

/**
 * Utility class for calculating library member borrowing analytics.
 */
public class LibraryAnalytics {

    // The percentile scale ranges from 0.0 to 100.0.
    private static final double MAX_PERCENTILE = 100.0;

    // Private constructor prevents instantiation of this utility class.
    private LibraryAnalytics() {
        // Utility class - not meant to be instantiated.
    }

    /**
     * Calculates the borrowing percentile of a member.
     *
     * The percentile represents the percentage of OTHER registered members
     * who currently hold fewer books than the selected member.
     * Members with the same number of borrowed books are treated as tied
     * and are not counted as having fewer books.
     *
     * A library with exactly one member returns 100.0 because there are
     * no other members to compare against.
     *
     * Time complexity: O(n), where n is the number of library members.
     *
     * @param member the member whose borrowing percentile is calculated
     * @param library the library whose members are compared
     * @return percentile in the range 0.0 to 100.0
     * @throws IllegalArgumentException if member or library is null,
     *         the library is empty, or the member is not registered
     */
    public static double borrowPercentile(Member member, Library library) {

        if (member == null || library == null) {
            throw new IllegalArgumentException(
                    "Member and library must not be null.");
        }

        List<Member> members = library.getAllMembers();
        int totalMembers = members.size();

        // An empty library cannot produce a borrowing percentile.
        if (totalMembers == 0) {
            throw new IllegalArgumentException(
                    "Library must contain at least one member.");
        }

        // The selected member must belong to this library.
        if (!members.contains(member)) {
            throw new IllegalArgumentException(
                    "Member is not registered in this library.");
        }

        // A single-member library has no other members for comparison.
        if (totalMembers == 1) {
            return MAX_PERCENTILE;
        }

        int memberLoans = member.getBorrowedBooks().size();
        long membersWithFewerLoans = 0;

        for (Member other : members) {
            if (other.getBorrowedBooks().size() < memberLoans) {
                membersWithFewerLoans++;
            }
        }

        // Compare against OTHER members, excluding the selected member.
        return (double) membersWithFewerLoans
                / (totalMembers - 1) * MAX_PERCENTILE;
    }
}
