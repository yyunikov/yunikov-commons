package ua.yyunikov.util;

import org.junit.Assert;
import org.junit.Test;
import ua.yyunikov.util.fake.FakeEnum;

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
    public void allByPredicate() {
        final Set<FakeEnum> allByOnePredicate = EnumValue.of(FakeEnum.class).allByPredicate(fakeEnum -> fakeEnum
                .index() == 1);
        Assert.assertEquals(2, allByOnePredicate.size());
    }

    @Test
    public void firstByName() {
        final Optional<FakeEnum> oneEnum = EnumValue.of(FakeEnum.class).firstByName("ONE");
        Assert.assertTrue(oneEnum.isPresent());
        //noinspection OptionalGetWithoutIsPresent
        Assert.assertEquals(FakeEnum.ONE, oneEnum.get());
    }

    @Test
    public void firstByPredicate() {
        final Optional<FakeEnum> oneEnum = EnumValue.of(FakeEnum.class)
                .firstByPredicate(fakeEnum -> fakeEnum.index() == 1);
        Assert.assertTrue(oneEnum.isPresent());
        Assert.assertEquals(FakeEnum.ONE, oneEnum.get());
    }
}