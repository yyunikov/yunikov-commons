package com.yunikov.commons.maybe;

import java.util.Collection;

/**
 * Represents a collection which can be empty, null or not empty.
 *
 * @author yyunikov
 * @since 1.8
 */
public class MaybeCollection<T> extends TypedMaybe<Collection<T>> {

    protected MaybeCollection(final Collection<T> collection) {
        super(collection);
    }

    /**
     * Returns a {@link MaybeCollection} object for a collection.
     *
     * @param collection any collection or null
     * @return {@link MaybeCollection} object for a collection
     */
    public static <T> MaybeCollection of(final Collection<T> collection) {
        return new MaybeCollection<>(collection);
    }

    /**
     * Shows if collection is null or empty.
     *
     * @return true if collection is null or empty, false otherwise
     */
    @Override
    public boolean empty() {
        return nullableValue() == null || nullableValue().isEmpty();
    }
}
