package com.yunikov.commons;

/**
 * Object which state can empty or not.
 *
 * @author yyunikov
 */
@FunctionalInterface
public interface Emptyable {

    /**
     * Shows if the state of the object is empty.
     *
     * @return true if is empty, false otherwise
     */
    boolean isEmpty();
}
