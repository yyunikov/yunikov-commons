package com.yunikov.commons.tests.maybe;

import com.yunikov.commons.maybe.MaybeCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Tests for {@link MaybeCollection} class.
 *
 * @author yyunikov
 */
public class MaybeCollectionTest {

    @Test
    public void emptyOnEmptyCollection() {
        Assert.assertTrue(emptyOptionalCollection().empty());
    }

    @Test
    public void emptyOnNull() {
        Assert.assertTrue(MaybeCollection.of(null).empty());
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
        MaybeCollection.of(null).get();
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
        Assert.assertEquals("[Test]", MaybeCollection.of(Collections.singleton("Test")).toString());
    }

    private MaybeCollection emptyOptionalCollection() {
        return MaybeCollection.of(Collections.emptyList());
    }

    private MaybeCollection notEmptyOptionalCollection() {
        return MaybeCollection.of(Collections.singleton("Test"));
    }
}