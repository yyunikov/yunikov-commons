package com.yunikov.commons;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Represents a object which can be lazily initialized. See
 * <a href="https://en.wikipedia.org/wiki/Lazy_loading">Lazy loading</a> design pattern.
 *
 * @author yyunikov
 * @since 1.8
 */
public class Lazy<T> {

    private T obj;

    public Lazy() {
    }

    /**
     * Get's the object value lazily.
     *
     * @param lazySupplier supplier of lazy initialization function
     * @return value
     */
    public T get(final Supplier<? extends T> lazySupplier) {
        if (obj == null) {
            obj = lazySupplier.get();
        }

        return obj;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        if (object instanceof Lazy) {
            final Lazy<?> lazy = (Lazy<?>) object;
            return Objects.equals(obj, lazy.obj);
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return obj.toString();
    }
}
