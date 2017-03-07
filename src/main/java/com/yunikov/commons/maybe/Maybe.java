package com.yunikov.commons.maybe;

/**
 * Object which state can empty or not. Is different from {@link java.util.Optional} in the way that it's state can
 * be null, empty or not empty. For example, {@link String} or {@link java.util.Collection} can be null or empty.
 *
 * @author yyunikov
 * @since 1.8
 */
@FunctionalInterface
public interface Maybe {

    /**
     * Shows if the state of the object is empty.
     *
     * @return true if is empty, false otherwise
     */
    boolean empty();
}
