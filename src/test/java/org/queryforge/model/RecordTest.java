package org.queryforge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    @Test
    @DisplayName("Value creation and type-safe accessors")
    void testValueCreationAndAccessors() {
        Value intVal = Value.of(42);
        assertEquals(DataType.INTEGER, intVal.type());
        assertEquals(42, intVal.asInt());

        Value strVal = Value.of("QueryForge");
        assertEquals(DataType.VARCHAR, strVal.type());
        assertEquals("QueryForge", strVal.asString());

        Value boolVal = Value.of(true);
        assertEquals(DataType.BOOLEAN, boolVal.type());
        assertTrue(boolVal.asBoolean());
    }

    @Test
    @DisplayName("Value should reject incompatible types or nulls")
    void testValueTypeValidation() {
        assertThrows(NullPointerException.class, () -> new Value(null, 123));
        assertThrows(NullPointerException.class, () -> new Value(DataType.INTEGER, null));
        assertThrows(IllegalArgumentException.class, () -> new Value(DataType.INTEGER, "not-an-int"));
        assertThrows(IllegalArgumentException.class, () -> new Value(DataType.VARCHAR, 123));
        assertThrows(IllegalArgumentException.class, () -> new Value(DataType.BOOLEAN, "false"));
    }

    @Test
    @DisplayName("Accessing wrong type from Value should throw IllegalStateException")
    void testValueInvalidAccessor() {
        Value strVal = Value.of("hello");
        assertThrows(IllegalStateException.class, strVal::asInt);
        assertThrows(IllegalStateException.class, strVal::asBoolean);

        Value intVal = Value.of(100);
        assertThrows(IllegalStateException.class, intVal::asString);
    }

    @Test
    @DisplayName("Record creation and field access")
    void testRecordCreationAndAccess() {
        Record record = Record.of(Value.of(1), Value.of("Alice"), Value.of(true));

        assertEquals(3, record.size());
        assertEquals(1, record.get(0).asInt());
        assertEquals("Alice", record.get(1).asString());
        assertTrue(record.get(2).asBoolean());
    }

    @Test
    @DisplayName("Record access out of bounds should throw IndexOutOfBoundsException")
    void testRecordOutOfBounds() {
        Record record = Record.of(Value.of(1));

        assertThrows(IndexOutOfBoundsException.class, () -> record.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> record.get(1));
    }

    @Test
    @DisplayName("Record rejects null lists, empty lists, or null values")
    void testRecordNullValidation() {
        assertThrows(NullPointerException.class, () -> new Record(null));
        assertThrows(IllegalArgumentException.class, () -> new Record(List.of()));

        List<Value> listWithNull = new ArrayList<>();
        listWithNull.add(Value.of(1));
        listWithNull.add(null);
        assertThrows(IllegalArgumentException.class, () -> new Record(listWithNull));
    }

    @Test
    @DisplayName("Record equality and immutability (defensive copy)")
    void testRecordEqualityAndImmutability() {
        List<Value> sourceList = new ArrayList<>();
        sourceList.add(Value.of(10));
        sourceList.add(Value.of("test"));

        Record record1 = new Record(sourceList);
        Record record2 = Record.of(Value.of(10), Value.of("test"));

        assertEquals(record1, record2);
        assertEquals(record1.hashCode(), record2.hashCode());

        // Modifying the source list does not change the record
        sourceList.add(Value.of(20));
        assertEquals(2, record1.size());

        // Returned values list is unmodifiable
        assertThrows(UnsupportedOperationException.class, () -> record1.getValues().add(Value.of(99)));
    }
}
