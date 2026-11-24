# Code Review Checklist - LibraryHub (Lab 9)

## 1. Correctness
- [ ] Does the code do what the method name/Javadoc claims, including edge cases (empty, one item, boundaries)?
- [ ] Are integer/double operations safe (no integer division where a decimal is expected, no divide-by-zero)?
- [ ] Are null / not-found / invalid inputs handled with a clear exception or return value?

## 2. Tests
- [ ] Is there at least one test per behaviour, including an error path?
- [ ] Do assertions check real values (not just "no exception")?
- [ ] Is there a test for the smallest input (0 or 1 item) and for a boundary?

## 3. Readability
- [ ] Do names say what things are (no `r`, `x`, `l`)?
- [ ] Is there a Javadoc/comment explaining non-obvious rules?
- [ ] Are there magic numbers that should be named constants?

## 4. Design
- [ ] Does it fit the existing structure (e.g. uses Library.getAllMembers() instead of reaching into fields)?
- [ ] Is there duplicated logic that should be one helper?
- [ ] Does it avoid side effects on the caller's data (e.g. sorting the original list)?

## 5. Risk
- [ ] Any security or data-exposure concern (returning internal mutable lists, hard-coded secrets)?
- [ ] Any performance concern (nested loops over all members/books)?
- [ ] Is it backwards compatible with existing callers and tests?

## 6. Lessons Learned from Code Review

- Always verify calculation formulas, especially denominators and percentage calculations.
- Handle edge cases such as empty libraries and single-member libraries.
- Validate method arguments and provide clear exceptions for invalid inputs.
- Write meaningful Javadoc explaining method behavior, parameters, return values, and time complexity.
- Add tests for minimum, middle, maximum, and boundary cases.
- Treat members with equal borrowing counts consistently.
- Use named constants instead of unexplained magic numbers.
- Use private constructors for utility classes containing only static methods.
- Run `mvn clean verify` before submitting a pull request.
- Address reviewer feedback before requesting final approval.
- Never merge a pull request before completing the required review process.