package com.yunikov.commons.junit;

import org.junit.runners.model.Statement;

/**
 * Statement for repeating the test specified number of times
 *
 * @author yyunikov
 * @since 1.5
 */
public class RepeatStatement extends Statement {

    private final int times;
    private final Statement statement;

    public RepeatStatement(final int times, final Statement statement) {
        this.times = times;
        this.statement = statement;
    }

    @Override
    public void evaluate() throws Throwable {
        for(int i = 0; i < times; i++) {
            statement.evaluate();
        }
    }
}
