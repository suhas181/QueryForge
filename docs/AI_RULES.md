# AI Rules


# QueryForge — AI Coding Agent Rules

You are assisting with QueryForge, an educational mini relational database engine written in Java.

The main goals are to learn database internals, develop strong engineering skills, maintain correctness, and build a project that can be explained confidently in technical interviews.

## 1. Read Documentation First

Before making code changes, read:
- README.md
- PROJECT_SPEC.md
- ROADMAP.md
- ARCHITECTURE.md
- TESTING.md
- TECH_DECISIONS.md
- AGENTS.md

Also read any other documentation relevant to the current feature.

Inspect the existing repository before proposing changes.

## 2. Work One Feature at a Time

- Implement only the current approved milestone.
- Do not build the entire project in one operation.
- Do not implement future features prematurely.
- Do not add unrelated features.
- Do not change the technology stack without approval.
- Do not make large architectural changes without explaining them first.

## 3. Explain Before Coding

Before implementing a feature, explain:

1. What problem the feature solves.
2. Why the feature is needed.
3. The relevant computer science concepts.
4. The proposed implementation.
5. Which files need to be created or changed.
6. What tests will verify the feature.
7. The important risks and edge cases.

Wait for explicit approval before making substantial changes.

## 4. Help the Developer Learn

The developer is building this project to improve practical engineering knowledge.

Therefore:
- Explain important concepts in beginner-friendly language.
- Explain non-obvious methods and design choices.
- Avoid unnecessary complexity.
- Explain how the execution flow works.
- Explain relevant data structures and algorithms.
- Explain time and space complexity where applicable.
- Compare alternatives when the choice is important.
- Identify likely interview questions.
- Give a small exercise to verify understanding.

Do not assume that generated code is understood merely because it compiles.

## 5. Coding Standards

- Use Java for the core database engine.
- Follow the Java version and build tool selected for the repository.
- Use clear names and focused methods.
- Keep classes modular.
- Avoid unnecessary dependencies.
- Handle errors explicitly.
- Validate input.
- Preserve existing working behavior.
- Do not introduce a frontend unless approved.
- Do not use an existing database to implement the core storage engine.

## 6. Testing Requirements

Every feature should include appropriate automated tests.

Tests should cover:
- Expected behavior.
- Invalid input.
- Boundary cases.
- Failure cases where relevant.
- Regression risks.

Run relevant tests after making changes.

Report the actual test command and results.

Never claim that tests passed if they were not run or their results were not verified.

## 7. Performance and Reliability Claims

Never invent:
- Benchmark numbers.
- Performance improvements.
- Supported concurrent user counts.
- Recovery guarantees.
- ACID compliance.
- Thread safety.
- SQL compatibility.

Claims must match the actual implementation and available evidence.

## 8. End-of-Feature Report

After completing a feature, stop and report:

1. What was implemented.
2. Files created or changed.
3. Tests added.
4. Actual test results.
5. How to run the feature.
6. How the code works.
7. Relevant DSA and CS concepts.
8. Known limitations.
9. Interview questions to practise.
10. A small exercise for the developer.

Update documentation when the feature changes the project plan or architecture.

## 9. Stop for Review

Do not automatically start the next milestone.

Wait until the developer has reviewed the implementation, asked questions, and explicitly approved proceeding.

The goal is not merely to generate code. The goal is to build a working database engine while helping the developer understand it.
