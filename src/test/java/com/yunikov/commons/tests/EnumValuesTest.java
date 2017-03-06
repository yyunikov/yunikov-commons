package com.yunikov.commons.tests;

import com.yunikov.commons.EnumValues;
import com.yunikov.commons.tests.fake.FakeAnotherEnum;
import com.yunikov.commons.tests.fake.FakeEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

/**
 * Tests for {@link EnumValues} class.
 *
 * @author yyunikov
 */
public class EnumValuesTest {

    @Test
    public void concats() {
        Assert.assertEquals("ONE|ONE_AGAIN|TWO", fakeEnumValue().concat());
    }

    @Test
    public void concatsFields() {
        Assert.assertEquals("1|1|2", fakeEnumValue().concat(fakeEnum -> String.valueOf(fakeEnum.index())));
    }

    @Test
    public void concatsFieldsWithAmpersand() {
        Assert.assertEquals("1&1&2", fakeEnumValue().concat(fakeEnum -> String.valueOf(fakeEnum.index()), "&"));
    }

    @Test
    public void convertsToNames() {
        Assert.assertEquals(new ArrayList<>(Arrays.asList("ONE", "ONE_AGAIN", "TWO")), fakeEnumValue().toNames());
    }

    @Test(expected = NullPointerException.class)
    public void doesNotAcceptNulls() {
        EnumValues.of(null);
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

    private EnumValues<FakeAnotherEnum> fakeAnotherEnumValue() {
        return EnumValues.of(FakeAnotherEnum.class);
    }

    private EnumValues<FakeEnum> fakeEnumValue() {
        return EnumValues.of(FakeEnum.class);
    }
}