package com.yunikov.commons.maybe;

/**
 * Represents a string which can be empty, null or not empty.
 *
 * @author yyunikov
 * @since 1.8
 */
public class MaybeString extends TypedMaybe<String> {

    protected MaybeString(final String str) {
        super(str);
    }

    /**
     * Returns a {@link MaybeString} object for a string.
     *
     * @param str any string or null
     * @return {@link MaybeString} object for a string
     */
    public static MaybeString of(final String str) {
        return new MaybeString(str);
    }

    /**
     * Shows if string is null or empty.
     *
     * @return true if string is null or empty, false otherwise
     */
    @Override
    public boolean empty() {
        return nullableValue() == null || nullableValue().isEmpty();
    }
}
