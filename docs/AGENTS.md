# Agents Guide


# QueryForge — Repository Agent Instructions

Before making changes, read AI_RULES.md and the relevant project documentation.

## Project Context

QueryForge is an educational mini relational database engine written in Java.

The objective is to build a working, testable database engine while learning database internals and core computer science concepts.

## Required Workflow

1. Inspect the current repository.
2. Read the relevant documentation.
3. Identify the current approved milestone in ROADMAP.md.
4. Explain the proposed implementation before making substantial changes.
5. Wait for approval before proceeding.
6. Implement only the approved feature.
7. Add or update automated tests.
8. Run relevant tests and report actual results.
9. Explain changed files, design decisions, and limitations.
10. Stop for review before beginning the next milestone.

## Development Rules

- Use Java for the core engine.
- Follow the existing build configuration.
- Do not introduce unnecessary dependencies.
- Do not use an existing database for core storage.
- Do not implement future features prematurely.
- Do not add a frontend without approval.
- Do not invent benchmark results or claim unverified behavior.
- Do not claim thread safety, ACID compliance, or crash safety without evidence.
- Update documentation when requirements or architectural decisions change.

## Learning Requirements

Explain important code and computer science concepts in beginner-friendly language.

For each feature, help the developer understand:
- The problem being solved.
- The implementation and execution flow.
- The relevant data structures and algorithms.
- Time and space complexity where applicable.
- Tests and edge cases.
- Design alternatives and trade-offs.
- Likely interview questions.

The developer must review and understand the code rather than blindly accepting generated changes.

## Stop Condition

After completing the approved feature and reporting test results, stop.

Wait for the developer to review the implementation and explicitly approve the next milestone.
