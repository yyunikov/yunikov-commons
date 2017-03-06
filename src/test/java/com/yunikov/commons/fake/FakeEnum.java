package com.yunikov.commons.fake;

/**
 * Fake enumeration used for tests.
 *
 * @author yyunikov
 */
public enum FakeEnum {
    ONE(1),
    ONE_AGAIN(1),
    TWO(2);

    private final int index;

    FakeEnum(final int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
