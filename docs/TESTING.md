# Testing Strategy


# QueryForge — Testing Strategy

## 1. Purpose

Testing is part of every feature, not something reserved for the end of development.

The engine must demonstrate correct behavior through repeatable tests.

## 2. Unit Tests

Test individual components independently.

Examples:
- Record validation.
- Query tokenization.
- Query parsing.
- Table schema validation.
- Index insertion and lookup.
- Storage format encoding and decoding.

## 3. Integration Tests

Test interactions between components.

Examples:
- Insert a record and retrieve it.
- Create a table and execute a query.
- Update a record and verify the result.
- Delete a record and verify it is no longer returned.
- Verify index results match full-scan results.

Only test features that have actually been implemented.

## 4. Persistence Tests

Verify that:
- Records can be written to files.
- Stored records can be read back.
- Data survives an application restart.
- Empty or missing files are handled correctly.
- Invalid stored data produces a clear, safe error.

Persistence tests must match the actual storage guarantees of the implementation.

## 5. Error and Boundary Tests

Consider:
- Empty commands.
- Malformed queries.
- Unsupported syntax.
- Missing tables.
- Invalid data types.
- Duplicate keys where applicable.
- Queries returning no records.
- Missing or inaccessible files.
- Failed writes where failure can be simulated safely.
- Corrupted or truncated stored data.

## 6. Transaction Tests

After transactions are implemented, test:
- Successful commits.
- Rollback behavior.
- Invalid transaction operations.
- Failure during an operation.
- Consistency after restarting the engine.

Do not claim ACID compliance based on a small number of passing tests. Document the actual guarantees.

## 7. Recovery Tests

After logging and recovery are implemented:
- Define the failure scenario.
- Reproduce the failure in a controlled test.
- Restart the engine.
- Verify the documented recovery behavior.
- Check that the recovered state satisfies the expected invariants.

## 8. Concurrency Tests

After concurrency is implemented:
- Define the supported concurrent operations.
- Test simultaneous reads and writes.
- Check for lost updates or inconsistent state.
- Repeat tests under contention.
- Verify that shared data remains consistent.

## 9. Benchmarking

- Benchmark only correct implementations.
- Compare equivalent operations.
- Record dataset sizes.
- Record relevant environment details.
- Use repeatable commands.
- Avoid drawing broad conclusions from tiny datasets.
- Do not invent or estimate results and present them as measurements.

For indexing, compare equivalent lookups with and without an index.

## 10. Definition of Done

A feature is ready for review when:
- Its tests are implemented.
- Relevant tests have been run.
- Results are reported honestly.
- Edge cases are considered.
- Known limitations are documented.
- The developer understands what the tests prove and what they do not prove.
