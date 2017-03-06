package com.yunikov.commons;

import java.util.Objects;

/**
 * Represents a tuple (pair) of two objects.
 *
 * @author root
 * @since 1.7
 */
public class Tuple<FIRST, SECOND> {

    private final FIRST first;
    private final SECOND second;

    private Tuple(final FIRST first, final SECOND second) {
        this.first = first;
        this.second = second;
    }

    public static <FIRST, SECOND> Tuple<FIRST, SECOND> of(final FIRST first, final SECOND second) {
        return new Tuple<>(first, second);
    }

    /**
     * First value.
     *
     * @return first value
     */
    public FIRST first() {
        return first;
    }

    /**
     * Second value
     *
     * @return second value
     */
    public SECOND second() {
        return second;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (o instanceof Tuple) {
            final Tuple<?, ?> tuple = (Tuple<?, ?>) o;
            return Objects.equals(first, tuple.first) &&
                    Objects.equals(second, tuple.second);
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[" + first + "," + second + "]";
    }
}
