package org.queryforge.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * An immutable tuple (row) consisting of an ordered list of typed Values.
 */
public final class Record {

    private final List<Value> values;

    public Record(List<Value> values) {
        Objects.requireNonNull(values, "Values list cannot be null");
        if (values.isEmpty()) {
            throw new IllegalArgumentException("A record must contain at least one value");
        }
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == null) {
                throw new IllegalArgumentException("Record value at index " + i + " cannot be null");
            }
        }
        this.values = List.copyOf(values);
    }

    public static Record of(Value... values) {
        Objects.requireNonNull(values, "Values array cannot be null");
        return new Record(Arrays.asList(values));
    }

    public Value get(int index) {
        if (index < 0 || index >= values.size()) {
            throw new IndexOutOfBoundsException("Column index " + index + " out of bounds for record with size " + values.size());
        }
        return values.get(index);
    }

    public int size() {
        return values.size();
    }

    public List<Value> getValues() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(values, record.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "(" + String.join(", ", values.stream().map(Value::toString).toList()) + ")";
    }
}
