package org.queryforge.storage;

import org.queryforge.model.Record;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * An in-memory storage manager that stores, retrieves, and deletes tuples
 * using auto-incrementing Row IDs (RIDs).
 */
public class InMemoryTable {

    private final String tableName;
    private final Map<Integer, Record> rows = new LinkedHashMap<>();
    private int nextRowId = 1;

    public InMemoryTable(String tableName) {
        Objects.requireNonNull(tableName, "Table name cannot be null");
        if (tableName.isBlank()) {
            throw new IllegalArgumentException("Table name cannot be blank");
        }
        this.tableName = tableName.trim();
    }

    public String getTableName() {
        return tableName;
    }

    /**
     * Inserts a record and assigns it a unique, sequential Row ID.
     *
     * @param record The record to insert (must be non-null)
     * @return The assigned Row ID
     */
    public int insert(Record record) {
        Objects.requireNonNull(record, "Record cannot be null");
        int rowId = nextRowId++;
        rows.put(rowId, record);
        return rowId;
    }

    /**
     * Retrieves a record by its Row ID.
     *
     * @param rowId The Row ID to look up
     * @return Optional containing the record if found, otherwise empty
     */
    public Optional<Record> get(int rowId) {
        return Optional.ofNullable(rows.get(rowId));
    }

    /**
     * Returns an unmodifiable list of all stored records in insertion order.
     */
    public List<Record> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(rows.values()));
    }

    /**
     * Deletes a record by its Row ID.
     *
     * @param rowId The Row ID to delete
     * @return true if the record was removed, false if it did not exist
     */
    public boolean delete(int rowId) {
        return rows.remove(rowId) != null;
    }

    /**
     * Returns the number of active records stored in the table.
     */
    public int size() {
        return rows.size();
    }

    /**
     * Returns true if the table has no records.
     */
    public boolean isEmpty() {
        return rows.isEmpty();
    }

    /**
     * Removes all records and resets the Row ID sequence.
     */
    public void clear() {
        rows.clear();
        nextRowId = 1;
    }
}
