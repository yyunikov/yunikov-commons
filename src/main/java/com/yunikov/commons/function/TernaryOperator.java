package com.yunikov.commons.function;

import java.util.function.UnaryOperator;

/**
 * Represents an operation upon three operands of the same type, producing a result
 * of the same type as the operands.  This is a specialization of
 * {@link TriFunction} for the case where the operands and the result are all of
 * the same type.
 *
 * @param <T> the type of the operands and result of the operator
 *
 * @see TriFunction
 * @see UnaryOperator
 * @since 1.8
 */
@FunctionalInterface
public interface TernaryOperator<T> extends TriFunction<T, T, T, T> {
}