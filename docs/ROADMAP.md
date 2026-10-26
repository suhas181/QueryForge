# Roadmap


# QueryForge — Development Roadmap

## How to Use This Roadmap

Implement one milestone at a time.

Before each milestone:
- Read the relevant documentation.
- Understand the requirements.
- Review the proposed design.
- Approve the implementation plan.

After each milestone:
- Run the tests.
- Review the code.
- Understand the execution flow.
- Complete a small exercise yourself.
- Update this roadmap based on verified progress.

## Milestone 0: Project Setup

- [x] Check the installed Java Development Kit.
- [x] Choose Maven or Gradle.
- [x] Create the Java project structure.
- [x] Configure JUnit.
- [x] Add the first automated test.
- [x] Verify the build.
- [x] Configure Git and .gitignore.
- [x] Document setup instructions.

Exit criteria: The project builds and the sample test passes. (Verified: 1 test passed, 0 failures).

## Milestone 1: In-Memory Record Management

- [x] Define the initial record representation. (Created Record and Value models)
- [x] Store records in memory. (Created InMemoryTable storage manager)
- [x] Add and retrieve records. (Implemented insert, get by row ID, and getAll)
- [x] Validate inputs. (Type validation, null checks, immutability enforcement)
- [x] Add unit tests. (Added RecordTest and InMemoryTableTest with 14 new tests)
- [x] Explain the chosen data structures. (Documented LinkedHashMap and Value array trade-offs)

Exit criteria: Records can be added, retrieved, and deleted in memory with full unit test coverage. (Verified: 15/15 tests passed).

Learning: Java, OOP, collections, testing.

## Milestone 2: Persistent File Storage

- [ ] Define an on-disk record format.
- [ ] Write records to files.
- [ ] Read records from files.
- [ ] Restart the application and verify persistence.
- [ ] Handle missing and malformed files.
- [ ] Test file operations.

Learning: File I/O, serialization, persistence, error handling.

## Milestone 3: Basic Query Language

- [ ] Define the supported query grammar.
- [ ] Tokenize query input.
- [ ] Parse supported commands.
- [ ] Represent parsed commands as structured objects.
- [ ] Separate parsing from execution.
- [ ] Add parser tests.
- [ ] Return meaningful syntax errors.

Learning: Parsing, validation, modular design.

## Milestone 4: Tables and Record Operations

- [ ] Introduce a table and schema model.
- [ ] Implement CREATE TABLE.
- [ ] Implement INSERT.
- [ ] Implement SELECT.
- [ ] Add UPDATE if the storage design supports it.
- [ ] Add DELETE if the storage design supports it.
- [ ] Validate supported data types.
- [ ] Test invalid operations.

Learning: Relational concepts, schemas, constraints.

## Milestone 5: Query Execution

- [ ] Implement simple filtering.
- [ ] Implement full-table scans.
- [ ] Document time complexity.
- [ ] Test matching and non-matching records.
- [ ] Create a benchmark baseline.

Learning: Algorithms, searching, complexity analysis.

## Milestone 6: Indexing

- [ ] Define supported index keys.
- [ ] Choose an initial index design.
- [ ] Implement and test index lookups.
- [ ] Consider a B+ tree implementation.
- [ ] Keep indexes consistent with inserts, updates, and deletes.
- [ ] Compare indexed lookups with full-table scans.
- [ ] Record benchmark methodology and results.

Learning: Trees, hashing, indexing, performance.

## Milestone 7: Transactions

- [ ] Define transaction boundaries.
- [ ] Define commit and rollback behavior.
- [ ] Implement a limited transaction model.
- [ ] Test successful commits.
- [ ] Test rollback and failure cases.
- [ ] Document supported guarantees.

Learning: ACID properties and transaction management.

## Milestone 8: Write-Ahead Logging and Recovery

- [ ] Define the supported crash scenarios.
- [ ] Design a write-ahead log.
- [ ] Implement logging and recovery.
- [ ] Test recovery after controlled failures.
- [ ] Document limitations and durability guarantees.

Learning: WAL, durability, crash recovery.

## Milestone 9: Concurrency

- [ ] Define the concurrency model.
- [ ] Identify possible race conditions.
- [ ] Add concurrent operation tests.
- [ ] Implement appropriate synchronization.
- [ ] Test for data consistency.
- [ ] Document thread-safety limitations.

Learning: Threads, locks, race conditions, synchronization.

## Milestone 10: Final Engineering Quality

- [ ] Add integration tests.
- [ ] Verify persistence and recovery behavior.
- [ ] Add repeatable benchmarks.
- [ ] Document architecture and design trade-offs.
- [ ] Provide example commands and expected results.
- [ ] Verify a fresh clone can build and run.
- [ ] Prepare a technical demo.
- [ ] Write resume bullets based only on verified features.

## Important Rule

Do not implement every milestone just to complete a checklist.

A smaller, reliable, well-tested database engine is better than a large project with incomplete or unverified features.
