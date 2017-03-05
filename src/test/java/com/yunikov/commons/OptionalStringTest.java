package com.yunikov.commons;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link OptionalString} class.
 *
 * @author yyunikov
 */
public class OptionalStringTest {

    @Test
    public void isEmptyOnNull() {
        Assert.assertTrue(OptionalString.of(null).isEmpty());
    }

    @Test
    public void isEmptyOnEmptyString() {
        Assert.assertTrue(emptyOptionalString().isEmpty());
    }

    @Test
    public void isNotEmptyOnNotEmptyString() {
        Assert.assertFalse(notEmptyOptionalString().isEmpty());
    }

    @Test
    public void supportsEquals() {
        Assert.assertEquals(emptyOptionalString(), emptyOptionalString());
        Assert.assertNotEquals(emptyOptionalString(), null);
        Assert.assertNotEquals(emptyOptionalString(), notEmptyOptionalString());
        Assert.assertNotEquals(emptyOptionalString(), 123);
    }

    @Test
    public void supportsHashCode() {
        Assert.assertTrue(emptyOptionalString().hashCode() == emptyOptionalString().hashCode());
        Assert.assertTrue(emptyOptionalString().hashCode() != notEmptyOptionalString().hashCode());
        Assert.assertTrue(emptyOptionalString().hashCode() != new Integer(123).hashCode());
    }

    private OptionalString emptyOptionalString() {
        return OptionalString.of("");
    }

    private OptionalString notEmptyOptionalString() {
        return OptionalString.of("Test");
    }
}