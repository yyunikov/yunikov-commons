package com.yunikov.commons;

import java.util.Objects;

/**
 * Represents and optional string which can be empty, null or not empty.
 *
 * @author yyunikov
 */
public class OptionalString implements Emptyable {

    private final String str;

    private OptionalString(final String str) {
        this.str = str;
    }

    /**
     * Returns a {@link OptionalString} object for a string.
     *
     * @param str any string or null
     * @return {@link OptionalString} object for a string
     */
    public static OptionalString of(final String str) {
        return new OptionalString(str);
    }

    /**
     * Shows if string is null or empty.
     *
     * @return true if string is null or empty, false otherwise
     */
    @Override
    public boolean empty() {
        return str == null || str.isEmpty();
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof OptionalString) {
            final OptionalString that = (OptionalString) o;
            return Objects.equals(str, that.str);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}
