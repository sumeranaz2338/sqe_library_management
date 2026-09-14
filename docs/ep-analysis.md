# Equivalence Partitioning Analysis - LibraryHub

## 1. fine_tier(days_overdue) - Overdue Fine Tier

**Rule:** Days overdue are divided into the following equivalence classes.

| Class | Description | Valid? | Representative | Expected |
|-------|-------------|--------|----------------|----------|
| C1 | days_overdue < 0 | Invalid | -3 | IllegalArgumentException |
| C2 | days_overdue = 0 | Valid | 0 | None |
| C3 | 1-7 days overdue | Valid | 4 | Low |
| C4 | 8-14 days overdue | Valid | 10 | Medium |
| C5 | 15-30 days overdue | Valid | 20 | High |
| C6 | 31+ days overdue | Valid | 45 | Severe |

## 2. Number of Books on Loan per Member

**Rule:** A member can borrow 0 to 5 books.

| Class | Description | Valid? | Representative | Expected |
|-------|-------------|--------|----------------|----------|
| C7 | 0-5 books | Valid | 3 | Borrow allowed |
| C8 | 6+ books | Invalid | 6 | Borrow rejected |

## 3. ISBN Validation

**Rule:** ISBN must contain exactly 13 numeric digits.

| Class | Description | Valid? | Representative | Expected |
|-------|-------------|--------|----------------|----------|
| C9 | Exactly 13 numeric digits | Valid | "1234567890123" | Valid |
| C10 | Empty ISBN | Invalid | "" | Invalid |
| C11 | Less than 13 digits | Invalid | "123456789" | Invalid |
| C12 | Contains letters | Invalid | "123456789012A" | Invalid |
| C13 | Contains symbols | Invalid | "12345-6789012" | Invalid |

## EP Limitation

Equivalence Partitioning selects representative values from each equivalence class. It may not detect errors that occur specifically at the boundaries between classes. For example, values such as 7/8, 14/15, 30/31, and 5/6 may reveal boundary errors that a single representative from each class could miss. Boundary Value Analysis is therefore needed to specifically test these boundaries.