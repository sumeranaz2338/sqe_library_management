# Test Cases - GradeBook

| TC-ID | Title | Requirement | Preconditions | Steps | Expected Result | Priority | Type |
|-------|-------|-------------|---------------|-------|-----------------|----------|------|
| TC-001 | Create Student with valid data | REQ-1 | None | Create Student('Ali', 101, [85,90,78]) | Student created | High | Positive |
| TC-002 | Create Student with empty scores | REQ-1 | None | Create Student('Bilal', 102, []) | Student created with empty scores | Medium | Positive |
| TC-003 | Duplicate roll number | REQ-2 | Student(101) exists | Create Student('Daniyal', 101) | ValueError raised | High | Negative |
| TC-004 | Add valid score | REQ-3 | Student exists | student.add_score(95) | Score added | High | Positive |
| TC-005 | Add negative score | REQ-4 | Student exists | student.add_score(-10) | ValueError raised | High | Negative |
| TC-006 | Add zero score | REQ-3 | Student exists | student.add_score(0) | Score added | Medium | Positive |
| TC-007 | Average with scores | REQ-5 | Student with scores exists | student.average() | Returns average | High | Positive |
| TC-008 | Average with no scores | REQ-6 | Student with empty scores | student.average() | Returns 0.0 | High | Positive |
| TC-009 | Average with one score | REQ-5 | Student with [92] | student.average() | Returns 92.0 | Medium | Positive |
| TC-010 | Average with all zeros | REQ-5 | Student with [0,0,0] | student.average() | Returns 0.0 | Medium | Positive |
| TC-011 | Multiple scores | REQ-3 | Student exists | Add 90,95,88 | Scores added | Medium | Positive |
| TC-012 | Find by roll number | REQ-7 | Student exists | get_student(101) | Returns student | High | Positive |