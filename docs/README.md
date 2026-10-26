
# QueryForge — Mini Relational Database Engine

QueryForge is an educational database engine built from scratch using Java. The goal is to understand how databases work internally by implementing a small, testable system step by step.

This project focuses on database internals, data structures, algorithms, file storage, query processing, transactions, concurrency, and system reliability.

QueryForge is a learning project. It is not intended to replace production databases such as PostgreSQL or SQLite.

## Project Goals

- Build a database engine that stores records persistently.
- Retrieve records after the application restarts.
- Implement a small SQL-like query language.
- Learn how database indexes improve lookup performance.
- Explore transactions and crash recovery.
- Apply DSA, OOP, DBMS, operating systems, and software testing.
- Measure performance through repeatable benchmarks.
- Build a project that can be explained confidently in technical interviews.

## Technology Stack

- Language: Java 21 LTS (Eclipse Adoptium Temurin 21.0.7+)
- Build tool: Apache Maven 3.10.0+
- Testing: JUnit Jupiter 5.11+
- Version control: Git and GitHub
- Development environment: VS Code or IntelliJ IDEA

## Build and Test Instructions

### Prerequisites
- JDK 21 installed (`java -version` should report 21)
- Apache Maven installed (`mvn -version`)

Ensure `JAVA_HOME` points to your Java 21 installation (macOS example):
```bash
export JAVA_HOME="/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home"
```

### Compile the Project
```bash
mvn clean compile
```

### Run Automated Tests
```bash
mvn test
```

### Run the Application Entry Point
```bash
mvn compile exec:java -Dexec.mainClass="org.queryforge.QueryForge"
# Or run compiled class directly:
java -cp target/classes org.queryforge.QueryForge
```


## Planned Features

1. Basic record management
2. Persistent file storage
3. SQL-like query parsing
4. Query execution
5. Table and schema management
6. Data indexing
7. Transactions and rollback
8. Write-ahead logging and crash recovery
9. Concurrency control
10. Automated testing and performance benchmarking

These features are planned. A feature is considered implemented only after its code and tests have been verified.

## Computer Science Concepts

- Data structures and algorithms
- Object-oriented programming
- Database management systems
- Operating systems and concurrency
- File systems and memory concepts
- Time and space complexity
- Software architecture and design
- Testing and debugging

## Development Philosophy

- Build one feature at a time.
- Understand the problem before writing code.
- Keep the architecture simple and modular.
- Write automated tests for every feature.
- Review AI-generated code instead of blindly accepting it.
- Never claim performance improvements without measurements.
- Document important design decisions and limitations.

## Current Status

Project stage: Planning and initial setup.

No database engine features should be considered complete until they have been implemented and verified.

## Documentation

- PROJECT_SPEC.md — Requirements and project scope
- ROADMAP.md — Development milestones
- ARCHITECTURE.md — Proposed system design
- AI_RULES.md — Instructions for AI coding agents
- TESTING.md — Testing strategy
- TECH_DECISIONS.md — Engineering decision log
- INTERVIEW_NOTES.md — Interview preparation
- AGENTS.md — Repository-specific agent guidance

## Long-Term Goal

Build a small but reliable database engine that demonstrates practical understanding of database internals and core software engineering concepts.
