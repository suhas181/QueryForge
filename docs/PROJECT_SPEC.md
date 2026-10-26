# Project Specification


# QueryForge — Project Specification

## 1. Problem Statement

Applications need to store data persistently, retrieve records efficiently, and protect data from corruption during updates and failures.

QueryForge explores how a database engine can provide these capabilities without relying on an existing database to implement its core storage and query-processing logic.

The project will implement a small relational database engine in Java. It will begin with basic persistent record storage and gradually add query processing, indexing, transactions, and recovery.

## 2. Project Objectives

- Understand how a database stores records.
- Implement file-based persistence.
- Build a small SQL-like query interface.
- Understand full-table scans and database indexes.
- Implement efficient data retrieval.
- Explore transaction processing and recovery.
- Understand concurrency and synchronization.
- Write tests that verify correctness and reliability.
- Learn to measure performance and explain trade-offs.

## 3. Intended Users

- The developer building QueryForge.
- Interviewers reviewing the project.
- Developers interested in learning database internals.

## 4. Core Requirements

### A. Project Foundation

- Use Java for the core database engine.
- Maintain a modular and understandable codebase.
- Configure an automated testing framework.
- Use Git for version control.
- Document how to build and run the project.

### B. Persistent Storage

- Define a simple record format.
- Store records in local files.
- Read stored records correctly.
- Preserve records after application restarts.
- Handle missing files and invalid data safely.

### C. Query Processing

Gradually support a limited SQL-like language.

Planned commands:

- CREATE TABLE
- INSERT
- SELECT
- UPDATE
- DELETE

The initial implementation must support only a clearly documented subset of these commands.

Unsupported syntax should produce clear errors rather than silently failing.

### D. Data Structures and Indexing

- Implement a full-table scan as a baseline.
- Understand the time complexity of record retrieval.
- Introduce an index after the baseline works.
- Consider a B+ tree for advanced indexing.
- Keep indexes consistent with data changes.
- Benchmark indexed lookups against full scans.

### E. Transactions

- Define what a transaction means in QueryForge.
- Introduce commit and rollback.
- Specify the guarantees the engine supports.
- Test transaction behavior.
- Document limitations.

### F. Logging and Recovery

- Explore write-ahead logging (WAL).
- Define the supported failure scenarios.
- Recover data according to documented guarantees.
- Test controlled failure scenarios.
- Never claim crash safety without evidence.

### G. Concurrency

- Define which operations can run concurrently.
- Understand race conditions.
- Add synchronization where required.
- Test concurrent reads and writes.
- Document thread-safety limitations.

### H. Quality and Performance

- Automated unit tests.
- Integration tests.
- Persistence tests.
- Error-handling tests.
- Repeatable performance benchmarks.
- Clear setup and usage instructions.

## 5. Non-Goals

The initial project will not attempt to provide:

- Full SQL compatibility.
- All features of PostgreSQL or SQLite.
- Production-grade database guarantees.
- Distributed replication.
- A complex web frontend.
- Advanced query optimization.
- Every SQL data type and operation.

## 6. Engineering Principles

Correctness comes before performance.

Simple, testable implementations are preferred over unnecessary complexity.

AI-generated code must be reviewed and understood.

Existing database systems must not implement the core storage engine.

Features must not be described as complete until implementation and testing have verified them.

## 7. Definition of Done

A feature is complete only when:

1. Its requirements are documented.
2. Its implementation is reviewed.
3. Automated tests are added.
4. Relevant tests pass.
5. Important edge cases are considered.
6. Known limitations are documented.
7. The developer can explain the implementation and its design decisions.
