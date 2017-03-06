package com.yunikov.commons;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Represents and optional collection which can be empty, null or not empty.
 *
 * @author yyunikov
 */
public class OptionalCollection<T> implements Emptyable, Supplier<Collection<T>> {

    private final Collection<T> collection;

    private OptionalCollection(final Collection<T> collection) {
        this.collection = collection;
    }

    /**
     * Returns a {@link OptionalCollection} object for a collection.
     *
     * @param collection any collection or null
     * @return {@link OptionalCollection} object for a collection
     */
    public static <T> OptionalCollection of(final Collection<T> collection) {
        return new OptionalCollection<>(collection);
    }

    /**
     * Shows if collection is null or empty.
     *
     * @return true if collection is null or empty, false otherwise
     */
    @Override
    public boolean empty() {
        return collection == null || collection.isEmpty();
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof OptionalCollection) {
            final OptionalCollection<?> that = (OptionalCollection<?>) o;
            return Objects.equals(collection, that.collection);
        }

        return false;
    }

    /**
     * Get's the collection value if it is present. If value is null - {@link NoSuchElementException} is thrown.
     *
     * @return collection value
     */
    @Override
    public Collection<T> get() {
        if (collection == null) {
            throw new NoSuchElementException("No value present");
        }

        return collection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collection);
    }

    @Override
    public String toString() {
        return collection.toString();
    }
}
