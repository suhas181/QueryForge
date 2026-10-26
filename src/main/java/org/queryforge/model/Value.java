package org.queryforge.model;

import java.util.Objects;

/**
 * An immutable, strongly-typed attribute value stored within a record.
 */
public record Value(DataType type, Object rawValue) {

    public Value {
        Objects.requireNonNull(type, "DataType cannot be null");
        Objects.requireNonNull(rawValue, "Value cannot be null");

        // Validate type alignment
        switch (type) {
            case INTEGER -> {
                if (!(rawValue instanceof Integer)) {
                    throw new IllegalArgumentException("Expected Integer for type INTEGER, but got: " + rawValue.getClass().getSimpleName());
                }
            }
            case VARCHAR -> {
                if (!(rawValue instanceof String)) {
                    throw new IllegalArgumentException("Expected String for type VARCHAR, but got: " + rawValue.getClass().getSimpleName());
                }
            }
            case BOOLEAN -> {
                if (!(rawValue instanceof Boolean)) {
                    throw new IllegalArgumentException("Expected Boolean for type BOOLEAN, but got: " + rawValue.getClass().getSimpleName());
                }
            }
        }
    }

    public static Value of(int value) {
        return new Value(DataType.INTEGER, value);
    }

    public static Value of(String value) {
        return new Value(DataType.VARCHAR, value);
    }

    public static Value of(boolean value) {
        return new Value(DataType.BOOLEAN, value);
    }

    public int asInt() {
        if (type != DataType.INTEGER) {
            throw new IllegalStateException("Cannot read " + type + " as Integer");
        }
        return (Integer) rawValue;
    }

    public String asString() {
        if (type != DataType.VARCHAR) {
            throw new IllegalStateException("Cannot read " + type + " as String");
        }
        return (String) rawValue;
    }

    public boolean asBoolean() {
        if (type != DataType.BOOLEAN) {
            throw new IllegalStateException("Cannot read " + type + " as Boolean");
        }
        return (Boolean) rawValue;
    }

    @Override
    public String toString() {
        if (type == DataType.VARCHAR) {
            return "'" + rawValue + "'";
        }
        return String.valueOf(rawValue);
    }
}
