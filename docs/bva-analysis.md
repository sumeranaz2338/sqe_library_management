# Boundary Value Analysis - GradeBook

## 1. letter_grade(score) - Score to Letter Grade

**Rule:** Score 0-100 → A, B, C, D, F
**Boundaries:** 0, 60, 70, 80, 90, 100

| Boundary | Value-1 | Value | Value+1 | Expected at Value-1 | Expected at Value | Expected at Value+1 |
|----------|---------|-------|---------|---------------------|-------------------|---------------------|
| Lower domain edge (0) | -1 | 0 | 1 | ValueError | 'F' | 'F' |
| F/D cut-off (60) | 59 | 60 | 61 | 'F' | 'D' | 'D' |
| D/C cut-off (70) | 69 | 70 | 71 | 'D' | 'C' | 'C' |
| C/B cut-off (80) | 79 | 80 | 81 | 'C' | 'B' | 'B' |
| B/A cut-off (90) | 89 | 90 | 91 | 'B' | 'A' | 'A' |
| Upper domain edge (100) | 99 | 100 | 101 | 'A' | 'A' | ValueError |

## 2. Number of Scores per Student

**Rule:** Student ke paas 1 se 6 scores hone chahiye
**Boundaries:** 1 and 6

| Boundary | Value-1 | Value | Value+1 | Expected at Value-1 | Expected at Value | Expected at Value+1 |
|----------|---------|-------|---------|---------------------|-------------------|---------------------|
| Lower edge (1) | 0 | 1 | 2 | ValueError | Valid | Valid |
| Upper edge (6) | 5 | 6 | 7 | Valid | Valid | ValueError |

## 3. Student Name Length

**Rule:** Max 50 characters, non-empty
**Boundaries:** 0 and 50

| Boundary | Value-1 | Value | Value+1 | Expected at Value-1 | Expected at Value | Expected at Value+1 |
|----------|---------|-------|---------|---------------------|-------------------|---------------------|
| Lower edge (1) | 0 (empty) | 1 | 2 | ValueError | Valid | Valid |
| Upper edge (50) | 49 | 50 | 51 | Valid | Valid | ValueError |