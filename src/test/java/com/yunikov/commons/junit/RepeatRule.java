package com.yunikov.commons.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Rule for repeating the test specified number of times.
 *
 * @author root
 * @since 1.5
 */
public class RepeatRule implements TestRule {

    @Override
    public Statement apply(final Statement base, final Description description) {
        final Repeat repeat = description.getAnnotation(Repeat.class);
        if (repeat != null) {
            final int times = repeat.times();
            return new RepeatStatement(times, base);
        }

        return base;
    }
}
