package com.yunikov.commons.tests.maybe;

import com.yunikov.commons.maybe.MaybeCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

/**
 * Tests for {@link MaybeCollection} class.
 *
 * @author yyunikov
 */
@SuppressWarnings("unchecked")
public class MaybeCollectionTest extends TypedMaybeTest<Collection> {

    @Test
    public void supportsToString() {
        Assert.assertEquals("[Test]", MaybeCollection.of(Collections.singleton("Test")).toString());
    }

    @Override
    protected MaybeCollection emptyMaybe() {
        return MaybeCollection.of(Collections.emptyList());
    }

    @Override
    protected MaybeCollection notEmptyMaybe() {
        return MaybeCollection.of(Collections.singleton("Test"));
    }

    @Override
    protected MaybeCollection nullMaybe() {
        return MaybeCollection.of(null);
    }
}