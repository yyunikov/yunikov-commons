package com.yunikov.commons.maybe;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author yyunikov
 */
public abstract class TypedMaybe<T> implements Maybe, Supplier<T> {

    private final T value;

    protected TypedMaybe(final T value) {
        this.value = value;
    }

    /**
     * Get's the value if it is present. If value is null - {@link NoSuchElementException} is thrown.
     *
     * @return value
     * @throws NoSuchElementException if value is null
     */
    @Override
    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }

        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        if (object instanceof TypedMaybe) {
            final TypedMaybe<?> that = (TypedMaybe<?>) object;
            return Objects.equals(value, that.value);
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return value.toString();
    }

    protected T nullableValue() {
        return value;
    }
}
