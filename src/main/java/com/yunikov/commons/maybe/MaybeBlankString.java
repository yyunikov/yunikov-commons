package com.yunikov.commons.maybe;

/**
 * Represents a string which can be empty, blank, null or not empty.
 *
 * @author yyunikov
 * @since 1.8
 */
public final class MaybeBlankString extends MaybeString {

    private MaybeBlankString(final String str) {
        super(str);
    }

    /**
     * Returns a {@link MaybeBlankString} object for a string.
     *
     * @param str any string or null
     * @return {@link MaybeBlankString} object for a string
     */
    public static MaybeBlankString of(final String str) {
        return new MaybeBlankString(str);
    }


    /**
     * Shows if string is null, blank or empty.
     *
     * @return true if string is null, blank or empty, false otherwise
     */
    @Override
    public boolean empty() {
        return super.empty() || nullableValue().trim().isEmpty();
    }
}
