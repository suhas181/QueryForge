# Architecture


# QueryForge — Architecture

## 1. Overview

QueryForge is a small relational database engine written in Java.

The initial implementation will be simple. Components will be introduced only when needed.

## 2. Proposed Execution Flow

User enters a command
        |
        v
Command Interface
        |
        v
Query Parser
        |
        v
Query Executor
        |
        +------------------+
        |                  |
        v                  v
Index              Storage Engine
                           |
                           v
                      Local Files

The index is optional until the indexing milestone.

Transaction management, logging, and concurrency controls will be added after the initial storage and query behavior is reliable.

## 3. Component Responsibilities

### Command Interface

Accepts user commands and displays results or errors.

The first version may use a simple command-line interface.

### Query Parser

Converts supported query text into a structured representation.

Parsing and execution should be separate responsibilities.

### Query Executor

Executes supported operations against tables and records.

It decides which storage or index operations are needed.

### Table and Schema Model

Represents tables, columns, supported data types, and applicable constraints.

### Storage Engine

Reads and writes records using QueryForge's own storage format.

The core storage engine must not delegate record persistence to an existing relational database.

### Index

Provides efficient lookup for supported keys.

The index must remain consistent with the underlying records.

### Transaction Manager

Introduced later to coordinate transaction operations and define commit and rollback behavior.

### Log and Recovery Component

Introduced later to record the information required for the project's documented recovery guarantees.

## 4. Design Principles

- Keep each component focused on a clear responsibility.
- Separate parsing from query execution.
- Avoid unnecessary abstractions.
- Avoid introducing a frontend before the engine works.
- Do not introduce distributed architecture without a clear requirement.
- Document important architectural changes.
- Prefer correctness and testability over premature optimization.

## 5. Error Handling

The engine should handle expected errors explicitly.

Examples:
- Malformed commands.
- Unsupported syntax.
- Invalid records.
- Missing tables.
- File read or write failures.
- Duplicate keys, if keys are supported.
- Invalid transaction operations.

Errors must not be silently ignored.

## 6. Performance

Begin with a correct implementation and establish a benchmark baseline.

Optimize only after measuring the current behavior.

Benchmark reports must include relevant environment details, dataset sizes, and methodology.

## 7. Architecture Evolution

This document describes the proposed design.

When a new feature requires a different design:
1. Explain the limitation of the current architecture.
2. Propose alternatives.
3. Discuss trade-offs.
4. Obtain approval.
5. Update this document and TECH_DECISIONS.md.
