# Equivalence Partitioning Analysis - GradeBook

## 1. letter_grade(score) - Score to Letter Grade

**Rule:** Score 0-100 → A, B, C, D, F

| Class | Description | Valid? | Representative | Expected |
|-------|-------------|--------|----------------|----------|
| C1 | score < 0 | Invalid | -10 | ValueError |
| C2 | 0-59 | Valid | 45 | 'F' |
| C3 | 60-69 | Valid | 65 | 'D' |
| C4 | 70-79 | Valid | 75 | 'C' |
| C5 | 80-89 | Valid | 85 | 'B' |
| C6 | 90-100 | Valid | 95 | 'A' |
| C7 | score > 100 | Invalid | 150 | ValueError |

## 2. Number of Scores per Student

**Rule:** Student ke paas 1 se 6 scores hone chahiye

| Class | Description | Valid? | Representative | Expected |
|-------|-------------|--------|----------------|----------|
| C8 | 0 scores | Invalid | 0 | ValueError |
| C9 | 1-6 scores | Valid | 3 | Valid |
| C10 | 7+ scores | Invalid | 8 | ValueError |

## 3. Student Name Validation

**Rule:** Non-empty, max 50 chars, only letters/spaces/hyphens

| Class | Description | Valid? | Representative | Expected |
|-------|-------------|--------|----------------|----------|
| C11 | Empty string | Invalid | "" | ValueError |
| C12 | Valid name | Valid | "Ali Khan" | Valid |
| C13 | Name with digits | Invalid | "Ali123" | ValueError |
| C14 | Name with symbols | Invalid | "Ali@Khan" | ValueError |
| C15 | Name > 50 chars | Invalid | "A"*51 | ValueError |

## EP Limitation

Boundaries test nahi karta. Lab 6 mein BVA karenge.