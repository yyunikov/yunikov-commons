package com.yunikov.commons.maybe;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Generic abstract {@link Maybe} object.
 *
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
     * Executes a function if value is not empty.
     *
     * @param consumer function to execute
     * @return {@link TypedMaybe} instance to perform further operation
     */
    public TypedMaybe<T> ifNotEmpty(final Consumer<? super T> consumer) {
        if (!empty()) {
            consumer.accept(value);
        }

        return this;
    }

    /**
     * Executes a function if value is empty.
     *
     * @param consumer function to execute
     * @return {@link TypedMaybe} instance to perform further operation
     */
    public TypedMaybe<T> ifEmpty(final Consumer<? super T> consumer) {
        if (empty()) {
            consumer.accept(value);
        }

        return this;
    }

    /**
     * Gets the value if not empty, otherwise gets the other value.
     *
     * @param other other value
     * @return not empty value or other value
     */
    public T getOrElse(final T other) {
        return !empty() ? value : other;
    }

    /**
     * Gets the value if not empty, otherwise executes the provided function.
     *
     * @param other other function
     * @return not empty value or performs other function
     */
    public T getOrElse(final Supplier<? extends T> other) {
        return !empty() ? value : other.get();
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
