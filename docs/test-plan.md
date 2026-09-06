# Test Plan - Library Management System

## 1. Introduction
This test plan documents the testing strategy for the Library Management System, a Python-based application for managing books, members, and borrowing operations.

## 2. Test Items
- `src/library_management.py` - Main Library module
- `Book` class (title, author, ISBN, category, copies)
- `Member` class (name, member_id, email, borrow limit)
- `Library` class (add_book, register_member, borrow_book, return_book, search_books)

## 3. Features to be Tested
- Add new books with validation (ISBN format, duplicate checks)
- Register members with validation (duplicate ID checks)
- Borrow books (availability check, borrowing limit)
- Return books (validation member borrowed the book)
- Search books by title, author, ISBN

## 4. Features NOT to be Tested
- **User Interface**: Library is a backend module, no GUI
- **Database**: In-memory storage only
- **Network/Web**: Local application only
- **Performance**: Beyond scope

## 5. Approach
- Manual testing using Python shell
- Negative testing for error conditions
- Defect tracking via GitHub Issues

## 6. Pass/Fail Criteria
- 100% of planned test cases pass
- Zero Critical/High severity defects remain open

## 7. Test Deliverables
- Test Plan (`docs/test-plan.md`)
- Test Cases (`docs/test-cases.md`)
- RTM (`docs/rtm.md`)
- Execution results

## 8. Environmental Needs
- Python 3.10+
- VS Code
- Git/GitHub

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
- Incomplete requirements