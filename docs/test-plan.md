# Test Plan - GradeBook Application

## 1. Introduction
This test plan documents testing strategy for GradeBook application.

## 2. Test Items
- Student class (name, roll_no, scores)
- add_score() method
- average() method

## 3. Features to be Tested
- Student creation
- Adding scores
- Average calculation
- Validation (negative scores, duplicate roll numbers)

## 4. Features NOT to be Tested
- UI (no user interface)
- Database (in-memory storage)
- Network (local application)

## 5. Approach
- Manual testing using Python shell
- Unit testing with unittest framework
- Defect tracking via GitHub Issues

## 6. Pass/Fail Criteria
- 100% test cases pass
- Zero Critical defects remain open

## 7. Test Deliverables
- Test Plan (this file)
- Test Cases (test-cases.md)
- RTM (rtm.md)

## 8. Environmental Needs
- Python 3.10+
- VS Code

## 9. Schedule
| Activity | Duration |
|----------|----------|
| Test Planning | 60 min |
| Test Cases | 75 min |
| RTM | 30 min |
| Execution | 35 min |

## 10. Risks
- Time constraints
- Manual testing errors