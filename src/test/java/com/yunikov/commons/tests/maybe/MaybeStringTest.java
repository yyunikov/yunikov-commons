package com.yunikov.commons.tests.maybe;

import com.yunikov.commons.maybe.MaybeString;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link MaybeString} class.
 *
 * @author yyunikov
 */
public class MaybeStringTest extends TypedMaybeTest<String> {

    @Test
    public void supportsToString() {
        Assert.assertEquals("Test", MaybeString.of("Test").toString());
    }

    @Override
    protected MaybeString emptyMaybe() {
        return MaybeString.of("");
    }

    @Override
    protected MaybeString notEmptyMaybe() {
        return MaybeString.of("Test");
    }

    @Override
    protected MaybeString nullMaybe() {
        return MaybeString.of(null);
    }
}