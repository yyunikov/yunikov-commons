package com.yunikov.commons;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Tests for {@link OptionalCollection} class.
 *
 * @author yyunikov
 */
public class OptionalCollectionTest {

    @Test
    public void emptyOnEmptyCollection() {
        Assert.assertTrue(emptyOptionalCollection().empty());
    }

    @Test
    public void emptyOnNull() {
        Assert.assertTrue(OptionalCollection.of(null).empty());
    }

    @Test
    public void getsNonNullValue() {
        Assert.assertNotNull(notEmptyOptionalCollection().get());
    }

    @Test
    public void notEmptyOnNotEmptyCollection() {
        Assert.assertFalse(notEmptyOptionalCollection().empty());
    }

    @Test(expected = NoSuchElementException.class)
    public void notGetsNullValue() {
        OptionalCollection.of(null).get();
    }

    @Test
    public void supportsEquals() {
        Assert.assertEquals(emptyOptionalCollection(), emptyOptionalCollection());
        Assert.assertNotEquals(emptyOptionalCollection(), null);
        Assert.assertNotEquals(emptyOptionalCollection(), notEmptyOptionalCollection());
        Assert.assertNotEquals(emptyOptionalCollection(), "");
    }

    @Test
    public void supportsHashCode() {
        Assert.assertTrue(emptyOptionalCollection().hashCode() == emptyOptionalCollection().hashCode());
        Assert.assertTrue(emptyOptionalCollection().hashCode() != notEmptyOptionalCollection().hashCode());
        Assert.assertTrue(emptyOptionalCollection().hashCode() != "".hashCode());
    }

    @Test
    public void supportsToString() {
        Assert.assertEquals("[Test]", OptionalCollection.of(Collections.singleton("Test")).toString());
    }

    private OptionalCollection emptyOptionalCollection() {
        return OptionalCollection.of(Collections.emptyList());
    }

    private OptionalCollection notEmptyOptionalCollection() {
        return OptionalCollection.of(Collections.singleton("Test"));
    }
}