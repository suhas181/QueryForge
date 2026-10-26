# Technical Decisions Log

# QueryForge — Technical Decision Log

## Purpose

Record important engineering decisions, the alternatives considered, and the trade-offs involved.

Do not record a proposed decision as accepted until it has been reviewed.

## Decision Status

- Proposed: Under consideration.
- Accepted: Approved for implementation.
- Superseded: Replaced by a later decision.

## Decision Template

### DEC-XXX: Decision title

- Status: Proposed / Accepted / Superseded
- Date:
- Context:
- Problem being solved:
- Options considered:
- Decision:
- Reasoning:
- Trade-offs:
- Consequences:
- Related files or milestones:

---

## Decisions to Make During Setup

### DEC-001: Java Version

- Status: Accepted
- Date: 2026-10-26
- Context: The project needs a stable, long-term supported Java runtime that supports modern language features (records, pattern matching) without requiring ongoing toolchain friction.
- Problem being solved: Selecting the foundational runtime environment for QueryForge.
- Options considered:
  - Java 23 (latest non-LTS, installed on machine).
  - Java 21 LTS (Eclipse Adoptium Temurin 21.0.7 LTS, installed on machine).
- Decision: Use Java 21 LTS (`Eclipse Adoptium OpenJDK 21.0.7+6-LTS`).
- Reasoning: Java 21 is the current Long-Term Support (LTS) release, industry-standard in production environments, and already present on the system. It offers stable modern language ergonomics (records, pattern matching, new collections APIs).
- Trade-offs: Doesn't have experimental Java 23 preview features, but ensures maximum ecosystem stability and interview relevance.
- Consequences: Enforce `<maven.compiler.release>21</maven.compiler.release>` in `pom.xml`.
- Related files or milestones: Milestone 0, `pom.xml`.

### DEC-002: Build Tool

- Status: Accepted
- Date: 2026-10-26
- Context: The project requires a reproducible way to compile code, manage dependencies, and execute automated tests.
- Problem being solved: Choosing a build automation tool suitable for an educational database internals project.
- Options considered:
  - Maven.
  - Gradle.
- Decision: Use Apache Maven (v3.10.0+).
- Reasoning: Maven provides a declarative, static `pom.xml` configuration with zero build script ambiguity. For an educational systems project, build configuration should not distract from database engine algorithms. It integrates natively with VS Code, IntelliJ IDEA, and CI pipelines.
- Trade-offs: XML syntax is more verbose than Gradle's Groovy/Kotlin DSL, but it is vastly easier to inspect and maintain without scripting bugs.
- Consequences: Project uses standard Maven conventions (`src/main/java`, `src/test/java`, `pom.xml`).
- Related files or milestones: Milestone 0, `pom.xml`.

### DEC-003: Initial Record Format

Status: Proposed

Context:
The storage engine needs a defined way to represent records in files.

Questions to resolve:
- Will records have a fixed or variable length?
- How will strings and other values be encoded?
- How will record boundaries be identified?
- How will invalid or truncated records be detected?

Decision:
Choose the simplest format that meets the initial requirements and is easy to test.

### DEC-004: Query Language Scope

Status: Proposed

Context:
The project needs a deliberately limited SQL-like grammar.

Questions to resolve:
- Which commands are supported first?
- Which data types are supported?
- Which filter expressions are supported?
- How are unsupported commands reported?

Decision:
Document the grammar before implementing the parser.

### DEC-005: Index Design

Status: Proposed

Context:
The engine needs a way to compare indexed retrieval with full-table scans.

Options:
- Begin with a simple hash-based index.
- Implement a B+ tree.
- Use a simple scan until indexing requirements are clear.

Decision:
First establish a correct full-scan baseline. Choose the index design at the indexing milestone.

### DEC-006: Transaction and Recovery Guarantees

Status: Proposed

Context:
The engine may eventually support transactions, logging, and recovery.

Questions to resolve:
- What does commit guarantee?
- What does rollback undo?
- Which crash scenarios must be handled?
- What concurrency model is supported?

Decision:
Define guarantees before implementing them. Do not claim full ACID compliance or production-grade durability without evidence.

---

## Ongoing Rule

Every significant architectural change should be documented here with its rationale and trade-offs.
