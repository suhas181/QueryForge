# QueryForge — Mini Relational Database Engine

[![Java 21](https://img.shields.io/badge/Java-21%20LTS-orange.svg)](https://adoptium.net/)
[![Maven Build](https://img.shields.io/badge/Build-Maven%203.10-blue.svg)](https://maven.apache.org/)
[![JUnit 5](https://img.shields.io/badge/Tested%20with-JUnit%205-green.svg)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/License-MIT-lightgrey.svg)](LICENSE)

QueryForge is an educational relational database engine built from scratch in Java. The goal of this project is to demystify database internals from first principles by implementing a testable, modular storage and query engine step-by-step.

> **Core Philosophy**: QueryForge never delegates record storage or query execution to an existing database engine (like SQLite, H2, or Postgres). Every tuple representation, file format, index, and query scan is written and verified by hand.

---

## Current Status

- **Milestone 0: Project Setup** — Completed & Verified (Java 21 LTS, Maven, JUnit 5)
- **Milestone 1: In-Memory Record Management** — Completed & Verified (Strongly-typed Values, Immutable Records, InMemoryTable with auto-incrementing Row IDs)
- **Milestone 2: Persistent File Storage** — Up next!

---

## Architectural Flow

```text
User Command / SQL
        │
        ▼
Command Interface (CLI)
        │
        ▼
   Query Parser (Tokenization -> AST)
        │
        ▼
  Query Executor
        │
        ├────────────────────────┐
        ▼                        ▼
      Index (B+ Tree / Hash)    Storage Engine
                                 │
                                 ▼
                            Disk Files
```

---

## Technology Stack

- **Language**: Java 21 LTS (Eclipse Adoptium Temurin 21.0.7+)
- **Build Tool**: Apache Maven 3.10.0+
- **Testing**: JUnit Jupiter 5.11+
- **VCS**: Git & GitHub

---

## Quick Start & Verification

### Prerequisites
- JDK 21+ installed and configured:
  ```bash
  export JAVA_HOME="/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home"
  ```
- Apache Maven installed (`mvn -version`).

### Build the Project
```bash
mvn clean compile
```

### Run Automated Tests
```bash
mvn test
```

### Run the Application Entry Point
```bash
java -cp target/classes org.queryforge.QueryForge
```

---

## Project Documentation

Detailed design documents, specifications, and learning notes are maintained in [`docs/`](docs/):

- [PROJECT_SPEC.md](docs/PROJECT_SPEC.md) — Comprehensive requirements and scope
- [ROADMAP.md](docs/ROADMAP.md) — Development milestones and exit criteria
- [ARCHITECTURE.md](docs/ARCHITECTURE.md) — Component responsibilities and system design
- [AI_RULES.md](docs/AI_RULES.md) — Strict rules and engineering constraints for coding agents
- [TESTING.md](docs/TESTING.md) — Testing philosophy and benchmark standards
- [TECH_DECISIONS.md](docs/TECH_DECISIONS.md) — Architecture decision records (ADRs)
- [INTERVIEW_NOTES.md](docs/INTERVIEW_NOTES.md) — Concept breakdown and technical interview preparation
- [AGENTS.md](docs/AGENTS.md) — Repository guidance for AI assistants

---

## License

This project is licensed under the MIT License.
