package com.yunikov.commons.function;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Represents an operation that accepts three input arguments and returns no
 * result.  This is the three-arity specialization of {@link Consumer}.
 * Unlike most other functional interfaces, {@code TriConsumer} is expected
 * to operate via side-effects.
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <P> the type of the third argument to the operation
 * @see Consumer
 * @since 1.8
 */
@FunctionalInterface
public interface TriConsumer<T, U, P> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @param p the third input argument
     */
    void accept(final T t, final U u, final P p);

    /**
     * Returns a composed {@code TriConsumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code TriConsumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default TriConsumer<T, U, P> andThen(final TriConsumer<? super T, ? super U, ? super P> after) {
        Objects.requireNonNull(after);

        return (l, r, p) -> {
            accept(l, r, p);
            after.accept(l, r, p);
        };
    }
}
