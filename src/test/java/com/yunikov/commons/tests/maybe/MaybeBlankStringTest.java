package com.yunikov.commons.tests.maybe;

import com.yunikov.commons.maybe.MaybeBlankString;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link MaybeBlankString} class.
 *
 * @author yyunikov
 */
public class MaybeBlankStringTest extends MaybeStringTest {

    @Test
    public void emptyOnBlankString() {
        Assert.assertTrue(MaybeBlankString.of("     ").empty());
    }

    @Test
    public void notEmptyOnNonBlankString() {
        Assert.assertFalse(MaybeBlankString.of(" Test ").empty());
    }

    @Override
    protected MaybeBlankString emptyMaybe() {
        return MaybeBlankString.of("  ");
    }

    @Override
    protected MaybeBlankString notEmptyMaybe() {
        return MaybeBlankString.of(" Test ");
    }

    @Override
    protected MaybeBlankString nullMaybe() {
        return MaybeBlankString.of(null);
    }
}