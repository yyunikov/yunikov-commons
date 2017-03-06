package com.yunikov.commons.tests;

import com.yunikov.commons.OptionalString;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Tests for {@link OptionalString} class.
 *
 * @author yyunikov
 */
public class OptionalStringTest {

    @Test
    public void emptyOnEmptyString() {
        Assert.assertTrue(emptyOptionalString().empty());
    }

    @Test
    public void emptyOnNull() {
        Assert.assertTrue(OptionalString.of(null).empty());
    }

    @Test
    public void getsNonNullValue() {
        Assert.assertNotNull(notEmptyOptionalString().get());
    }

    @Test
    public void notEmptyOnNotEmptyString() {
        Assert.assertFalse(notEmptyOptionalString().empty());
    }

    @Test(expected = NoSuchElementException.class)
    public void notGetsNullValue() {
        OptionalString.of(null).get();
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

    @Test
    public void supportsToString() {
        Assert.assertEquals("Test", OptionalString.of("Test").toString());
    }

    private OptionalString emptyOptionalString() {
        return OptionalString.of("");
    }

    private OptionalString notEmptyOptionalString() {
        return OptionalString.of("Test");
    }
}