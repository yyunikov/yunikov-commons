package com.yunikov.commons.tests.maybe;

import com.yunikov.commons.maybe.MaybeBlankString;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link MaybeBlankString} class.
 *
 * @author yyunikov
 */
public class MaybeBlankStringTest {

    @Test
    public void emptyOnBlankString() {
        Assert.assertTrue(MaybeBlankString.of("     ").empty());
    }

    @Test
    public void notEmptyOnNonBlankString() {
        Assert.assertFalse(MaybeBlankString.of(" asd ").empty());
    }
}