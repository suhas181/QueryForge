# Interview Notes


# QueryForge — Interview Preparation Notes

## 1. Project Overview

Answer these questions in your own words:

- What problem does QueryForge explore?
- Why did I build a database engine instead of another CRUD application?
- What features have I actually implemented?
- What is deliberately out of scope?
- How does a query move through the system?
- What are the biggest limitations of my implementation?

## 2. Java and OOP

- What is the purpose of each major class?
- Why are responsibilities separated?
- Where are interfaces useful?
- How are exceptions handled?
- How does the code avoid unnecessary coupling?

## 3. Data Structures and Algorithms

- What is a full-table scan?
- What is its time complexity?
- Why are indexes useful?
- What is hashing?
- What is a B-tree?
- What is a B+ tree?
- How does a B+ tree lookup work?
- What is the complexity of the selected index?
- What extra work is required to maintain an index?
- What do my benchmarks actually demonstrate?

## 4. Storage Engine

- How are records represented on disk?
- How are records written and read?
- How are record boundaries identified?
- How does the engine locate a particular record?
- What happens when the application restarts?
- What happens when a stored file is malformed?
- What are the limitations of the current storage format?

## 5. Query Processing

- What is tokenization?
- What is parsing?
- How does the parser represent a query?
- Why separate parsing from execution?
- How are invalid commands handled?
- What syntax does my engine support?
- How are results produced?

## 6. Database Fundamentals

- What is a table and a schema?
- What is a primary key?
- What is an index?
- What is a transaction?
- What are the ACID properties?
- Which ACID properties does my implementation support?
- What does commit mean?
- What does rollback mean?

## 7. Logging and Recovery

Complete these questions only after implementing the relevant features.

- What is a write-ahead log?
- Why is logging needed?
- What happens during recovery?
- Which failure scenarios have I tested?
- Which guarantees are not supported?
- How do I know recovery worked correctly?

## 8. Operating Systems and Concurrency

Complete these questions as the project develops.

- What is the difference between a process and a thread?
- What is a race condition?
- What is a critical section?
- Why are locks needed?
- Which operations can run concurrently?
- How does the implementation protect shared state?
- Which concurrency tests have I written?

## 9. Testing and Performance

- What is the difference between unit and integration tests?
- How do I run the test suite?
- What important bugs did I find?
- How did I measure performance?
- What environment and dataset sizes did I use?
- What do the results prove?
- What do the results not prove?

## 10. Personal Learning Log

After every milestone, write:

### Milestone: Milestone 0: Project Setup
### One concept I learned: How Maven organizes standard Java project structure (src/main/java and src/test/java) and enforces JDK release targeting via pom.xml.
### One bug I found: None encountered during initial setup.
### How I diagnosed and fixed it: N/A
### One important design decision: Selected Java 21 LTS (Temurin) and Maven to ensure ecosystem stability without build script complexity.
### An alternative I considered: Java 23 (non-LTS) and Gradle.
### A limitation that remains: Engine does not yet store or process data; only baseline project lifecycle and test framework are configured.
### One interview question I can now answer: What is the purpose of Maven's test phase, and how does the Surefire plugin discover and execute JUnit 5 tests?
### One exercise I completed without AI: Verified `mvn clean test` from the terminal.

---

### Milestone: Milestone 1: In-Memory Record Management
### One concept I learned: Modeling database tuples using Java immutable objects (Value and Record) and managing in-memory rows using LinkedHashMap for O(1) RID lookups and deterministic insertion ordering.
### One bug I found: External callers could theoretically mutate returned row collections if internal lists were exposed directly.
### How I diagnosed and fixed it: Applied defensive copying and wrapped list access in Collections.unmodifiableList.
### One important design decision: Strongly typing Value with a DataType enum to catch type mismatches at tuple creation rather than failing downstream during execution.
### An alternative I considered: Raw Object[] array for records without type metadata (simpler, but prone to silent type errors and runtime ClassCastExceptions).
### A limitation that remains: Records exist purely in RAM; data is lost when the JVM process stops.
### One interview question I can now answer: What is defensive copying, why is it essential in systems design, and what are the time/space complexities of row lookup by ID vs. a full scan?
### One exercise I completed without AI: Inspecting and testing row deletion and auto-incrementing ID mechanics.


## Important Rule

Only claim knowledge and features that I can explain honestly and demonstrate through the implementation.
