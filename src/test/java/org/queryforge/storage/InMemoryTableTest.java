package org.queryforge.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.queryforge.model.Record;
import org.queryforge.model.Value;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTableTest {

    private InMemoryTable table;

    @BeforeEach
    void setUp() {
        table = new InMemoryTable("users");
    }

    @Test
    @DisplayName("Table name validation")
    void testTableNameValidation() {
        assertEquals("users", table.getTableName());
        assertThrows(NullPointerException.class, () -> new InMemoryTable(null));
        assertThrows(IllegalArgumentException.class, () -> new InMemoryTable("   "));
    }

    @Test
    @DisplayName("Insert and retrieve records by Row ID")
    void testInsertAndGet() {
        Record alice = Record.of(Value.of(1), Value.of("Alice"));
        Record bob = Record.of(Value.of(2), Value.of("Bob"));

        int id1 = table.insert(alice);
        int id2 = table.insert(bob);

        assertEquals(1, id1);
        assertEquals(2, id2);
        assertEquals(2, table.size());
        assertFalse(table.isEmpty());

        Optional<Record> retrievedAlice = table.get(id1);
        assertTrue(retrievedAlice.isPresent());
        assertEquals(alice, retrievedAlice.get());

        Optional<Record> retrievedBob = table.get(id2);
        assertTrue(retrievedBob.isPresent());
        assertEquals(bob, retrievedBob.get());
    }

    @Test
    @DisplayName("Get non-existent Row ID returns empty Optional")
    void testGetNonExistentRowId() {
        assertTrue(table.get(999).isEmpty());
        assertTrue(table.get(-1).isEmpty());
    }

    @Test
    @DisplayName("Get all records preserves insertion order")
    void testGetAllRecords() {
        Record r1 = Record.of(Value.of(1), Value.of("First"));
        Record r2 = Record.of(Value.of(2), Value.of("Second"));
        Record r3 = Record.of(Value.of(3), Value.of("Third"));

        table.insert(r1);
        table.insert(r2);
        table.insert(r3);

        List<Record> all = table.getAll();
        assertEquals(3, all.size());
        assertEquals(r1, all.get(0));
        assertEquals(r2, all.get(1));
        assertEquals(r3, all.get(2));

        // Returned list must be unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> all.add(Record.of(Value.of(4))));
    }

    @Test
    @DisplayName("Delete record by Row ID")
    void testDeleteRecord() {
        Record record = Record.of(Value.of(1), Value.of("DeleteMe"));
        int id = table.insert(record);

        assertEquals(1, table.size());
        assertTrue(table.delete(id));
        assertEquals(0, table.size());
        assertTrue(table.get(id).isEmpty());

        // Deleting non-existent ID returns false
        assertFalse(table.delete(id));
        assertFalse(table.delete(999));
    }

    @Test
    @DisplayName("Clear removes all records and resets sequence")
    void testClear() {
        table.insert(Record.of(Value.of(1)));
        table.insert(Record.of(Value.of(2)));
        assertEquals(2, table.size());

        table.clear();
        assertEquals(0, table.size());
        assertTrue(table.isEmpty());

        // Next insert after clear starts at ID 1 again
        int newId = table.insert(Record.of(Value.of(100)));
        assertEquals(1, newId);
    }

    @Test
    @DisplayName("Insert rejects null record")
    void testInsertNullRecord() {
        assertThrows(NullPointerException.class, () -> table.insert(null));
    }
}
