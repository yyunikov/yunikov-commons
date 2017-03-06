package com.yunikov.commons.tests;

import com.yunikov.commons.Lazy;
import com.yunikov.commons.junit.Repeat;
import com.yunikov.commons.junit.RepeatRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * Tests for {@link Lazy} class.
 *
 * @author root
 * @since 1.8
 */
public class LazyTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 10)
    public void getsValueLazily() {
        final Lazy<Integer> integerLazy = new Lazy<>();
        Assert.assertEquals(fakeLazyGet(integerLazy), fakeLazyGet(integerLazy));
    }

    private Integer fakeLazyGet(final Lazy<Integer> lazyObject) {
        return lazyObject.get(() -> {
            if (new Random().nextBoolean()) {
                return 1;
            }

            return 2;
        });
    }
}