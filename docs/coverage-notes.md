# Coverage Notes (Lab 11)

Tool: JaCoCo 0.8.12 via Maven (`mvn clean verify`). HTML report: `target/site/jacoco/index.html`.

## 1. Baseline vs final
| Metric | Baseline | Final |
|--------|----------|-------|
| Line coverage (JaCoCo check) | 65 % | above 85 % (check passed) |
| Branch coverage (JaCoCo check) | 64 % | above 80 % (check passed) |
| Instruction coverage (HTML report) | 60 % | 94 % |
| Branch coverage (HTML report) | 64 % | 93 % |
| Tests | 74 | 104 |

## 2. Three weakest files at baseline
| File | Coverage | What was untested |
|------|----------|-------------------|
| Member.java | 39 % | setters, toString |
| Book.java | 42 % | setters, isAvailable, toString |
| Library.java | 50 % | error paths in addBook, borrowBook, returnBook, searchBooks |

`SonarDemo.java` is 0 % because it is a demo file for Lab 10, not production code.

## 3. Tests added
LibraryOperationsTest (17), BookTest (3), MemberTest (4), GradeBookIOErrorTest (2), RosterAndValidationGapsTest (4).

## 4. Coverage trap
`LibraryTest.memberWithThreeBooksCanBorrowAnotherBook` used only `assertDoesNotThrow(...)`. It ran every line of `borrowBook`, so coverage was high, but it would still pass if the method forgot to reduce the copies or add the book to the member. I added assertions for the returned message, the member's loan count (4) and the book's remaining copies (0).
Lesson: coverage shows what code ran, not whether anything was checked.

## 5. Threshold proof
`pom.xml` has a JaCoCo `check` rule (line >= 0.85, branch >= 0.80). I temporarily renamed `LibraryOperationsTest.java` and `mvn clean verify` ended in BUILD FAILURE. After restoring it, the build passed again.