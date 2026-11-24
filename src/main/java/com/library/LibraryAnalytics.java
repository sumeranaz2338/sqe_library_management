package com.library;

import java.util.List;

public class LibraryAnalytics {

    public static double borrowPercentile(Member m, Library l) {
        List<Member> all = l.getAllMembers();
        int r = 0;
        for (Member x : all) {
            if (x.getBorrowedBooks().size() < m.getBorrowedBooks().size()) {
                r++;
            }
        }
        return r / all.size() * 100;
    }
}