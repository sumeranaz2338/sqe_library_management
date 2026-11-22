# SonarQube Cloud Findings (Lab 10)

Tool: SonarQube Cloud (Automatic Analysis). Project: sumeranaz2338_sqe_library_management

## Scan results on main
- Security: 0 issues (A), Reliability: 0 issues (A), Maintainability: 0 issues (A)
- Duplications: 22.0%
- Coverage: not configured yet (done in Lab 11)

## Demo issue introduced on branch chore/sonar-demo (PR #19)
| Rule | File : line | Severity | Risk (my own words) |
|------|-------------|----------|---------------------|
| Strings and Boxed types should be compared using "equals()" | SonarDemo.java : L26 | Reliability, Medium | `==` compares object references, so two equal texts can be treated as different. |

## Fix
Replaced `name == "admin"` with `"admin".equals(name)`. After a re-scan, the PR shows 0 issues.