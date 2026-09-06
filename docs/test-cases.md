# Test Cases - Library Management System

## Functional Requirements

| Requirement ID | Description |
|----------------|-------------|
| REQ-1 | Add book with valid ISBN, title, author, category, copies |
| REQ-2 | Reject duplicate ISBN |
| REQ-3 | Reject malformed ISBN (less than 10 characters) |
| REQ-4 | Register member with valid name, ID, email |
| REQ-5 | Reject duplicate member ID |
| REQ-6 | Borrow book when copies are available |
| REQ-7 | Reject borrow when NO copies available |
| REQ-8 | Return a book that was borrowed by that member |
| REQ-9 | Reject return of book NOT borrowed by that member |
| REQ-10 | Allow borrow up to 3 books (limit) |
| REQ-11 | Reject borrow beyond 3 books limit |
| REQ-12 | Search books by title/author/ISBN |

## Test Cases Table

| TC-ID | Title | Requirement | Preconditions | Steps | Expected Result | Priority | Type |
|-------|-------|-------------|---------------|-------|-----------------|----------|------|
| TC-001 | Add book with valid data | REQ-1 | Library empty | add_book('Python', 'John', '9780132350884', 'Programming', 5) | Book added, copies=5 | High | Positive |
| TC-002 | Add book with duplicate ISBN | REQ-2 | Book with ISBN exists | add_book('Another', 'Jane', '9780132350884', 'Fiction', 3) | ValueError: "already exists" | High | Negative |
| TC-003 | Add book with malformed ISBN | REQ-3 | None | add_book('Test', 'Author', '12345', 'Science', 2) | ValueError: "Invalid ISBN" | High | Negative |
| TC-004 | Register member with valid data | REQ-4 | None | register_member('Ali', 'M001', 'ali@email.com') | Member registered | High | Positive |
| TC-005 | Register member with duplicate ID | REQ-5 | Member 'M001' exists | register_member('Bilal', 'M001', 'bilal@email.com') | ValueError: "already exists" | High | Negative |
| TC-006 | Borrow book when copies available | REQ-6 | Book has 5 copies, Member exists | borrow_book('M001', '9780132350884') | Borrow successful, copies=4 | High | Positive |
| TC-007 | Borrow book when NO copies | REQ-7 | Book has 0 copies | borrow_book('M001', '9780132350884') | ValueError: "No copies available" | High | Negative |
| TC-008 | Return book that was borrowed | REQ-8 | Member borrowed the book | return_book('M001', '9780132350884') | Return successful, copies=5 | High | Positive |
| TC-009 | Return book NOT borrowed | REQ-9 | Member hasn't borrowed | return_book('M001', '9780132350884') | ValueError: "not borrowed" | High | Negative |
| TC-010 | Borrow at limit (3 books) | REQ-10 | Member has 2 books borrowed | borrow_book('M001', '333-3333') | Borrow successful | Medium | Positive |
| TC-011 | Borrow beyond limit (4th) | REQ-11 | Member has 3 books borrowed | borrow_book('M001', '444-4444') | ValueError: "borrowing limit" | High | Negative |
| TC-012 | Search books by title | REQ-12 | Books exist | search_books('Python') | Returns matching books | Medium | Positive |