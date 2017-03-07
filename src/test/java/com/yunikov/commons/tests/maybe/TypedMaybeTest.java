package com.yunikov.commons.tests.maybe;

import com.yunikov.commons.maybe.MaybeString;
import com.yunikov.commons.maybe.TypedMaybe;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Tests for {@link TypedMaybe} class.
 *
 * @author yyunikov
 */
public abstract class TypedMaybeTest<T> {

    @Test
    public void emptyOnEmptyValue() {
        Assert.assertTrue(emptyMaybe().empty());
    }

    @Test
    public void emptyOnNull() {
        Assert.assertTrue(MaybeString.of(null).empty());
    }

    @Test
    public void getsNonNullValue() {
        Assert.assertNotNull(notEmptyMaybe().get());
    }

    @Test
    public void getsOnOrElse() {
        notEmptyMaybe().getOrElse(() -> {
            Assert.fail("This should never by called");
            return null;
        });
    }

    @Test
    public void ifEmptyNotExecutes() {
        notEmptyMaybe().ifEmpty(value -> Assert.fail("This should never by called"));
    }

    @Test
    public void ifNotNotExecutes() {
        emptyMaybe().ifNotEmpty(value -> Assert.fail("This should never by called"));
    }

    @Test
    public void notEmptyOnNotEmptyValue() {
        Assert.assertFalse(notEmptyMaybe().empty());
    }

    @Test(expected = NoSuchElementException.class)
    public void notGetsNullValue() {
        nullMaybe().get();
    }

    @Test
    public void supportsEquals() {
        Assert.assertEquals(emptyMaybe(), emptyMaybe());
        Assert.assertNotEquals(emptyMaybe(), null);
        Assert.assertNotEquals(emptyMaybe(), notEmptyMaybe());
        Assert.assertNotEquals(emptyMaybe(), 134643223);
    }

    @Test
    public void supportsHashCode() {
        Assert.assertTrue(emptyMaybe().hashCode() == emptyMaybe().hashCode());
        Assert.assertTrue(emptyMaybe().hashCode() != notEmptyMaybe().hashCode());
        Assert.assertTrue(emptyMaybe().hashCode() != new Integer(134643223).hashCode());
    }

    protected abstract TypedMaybe<T> emptyMaybe();

    protected abstract TypedMaybe<T> notEmptyMaybe();

    protected abstract TypedMaybe<T> nullMaybe();
}