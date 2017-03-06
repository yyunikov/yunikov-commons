package com.yunikov.commons;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

/**
 * Tests for {@link OptionalCollection} class.
 *
 * @author yyunikov
 */
public class OptionalCollectionTest {

    @Test
    public void isEmptyOnNull() {
        Assert.assertTrue(OptionalCollection.of(null).empty());
    }

    @Test
    public void isEmptyOnEmptyCollection() {
        Assert.assertTrue(emptyOptionalCollection().empty());
    }

    @Test
    public void isNotEmptyOnNotEmptyCollection() {
        Assert.assertFalse(notEmptyOptionalCollection().empty());
    }

    private OptionalCollection notEmptyOptionalCollection() {
        return OptionalCollection.of(Collections.singleton("Test"));
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

    private OptionalCollection emptyOptionalCollection() {
        return OptionalCollection.of(Collections.emptyList());
    }
}