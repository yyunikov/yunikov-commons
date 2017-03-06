package com.yunikov.commons;

import com.yunikov.commons.fake.FakeAnotherEnum;
import com.yunikov.commons.fake.FakeEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

/**
 * Tests for {@link EnumValue} class.
 *
 * @author yyunikov
 */
public class EnumValueTest {

    @Test(expected = NullPointerException.class)
    public void doesNotAcceptNulls() {
        EnumValue.of(null);
    }

    @Test
    public void findsAllByPredicate() {
        final Set<FakeEnum> allByOnePredicate = fakeEnumValue().allByPredicate(fakeEnum -> fakeEnum
                .index() == 1);
        Assert.assertEquals(2, allByOnePredicate.size());
        Assert.assertTrue(allByOnePredicate.contains(FakeEnum.ONE));
        Assert.assertTrue(allByOnePredicate.contains(FakeEnum.ONE_AGAIN));
    }

    @Test
    public void findsFirstByName() {
        final Optional<FakeEnum> oneEnum = fakeEnumValue().firstByName("ONE");
        Assert.assertTrue(oneEnum.isPresent());
        Assert.assertFalse(fakeEnumValue().firstByName("NOT_EXISTING").isPresent());
        Assert.assertFalse(fakeEnumValue().firstByName(null).isPresent());
        //noinspection OptionalGetWithoutIsPresent
        Assert.assertEquals(FakeEnum.ONE, oneEnum.get());
    }

    @Test
    public void findsFirstByPredicate() {
        final Optional<FakeEnum> oneEnum = fakeEnumValue().firstByPredicate(fakeEnum -> fakeEnum.index() == 1);
        Assert.assertTrue(oneEnum.isPresent());
        Assert.assertEquals(FakeEnum.ONE, oneEnum.get());
    }

    @Test
    public void supportsEquals() {
        Assert.assertEquals(fakeEnumValue(), fakeEnumValue());
        Assert.assertNotEquals(fakeEnumValue(), null);
        Assert.assertNotEquals(fakeEnumValue(), fakeAnotherEnumValue());
    }

    @Test
    public void supportsHashCode() {
        Assert.assertTrue(fakeEnumValue().hashCode() == fakeEnumValue().hashCode());
        Assert.assertTrue(fakeEnumValue().hashCode() != fakeAnotherEnumValue().hashCode());
    }

    private EnumValue<FakeAnotherEnum> fakeAnotherEnumValue() {
        return EnumValue.of(FakeAnotherEnum.class);
    }

    private EnumValue<FakeEnum> fakeEnumValue() {
        return EnumValue.of(FakeEnum.class);
    }
}