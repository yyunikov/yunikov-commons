package ua.yyunikov.util;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contains methods for working with specific enumeration, mainly for quick finding different instances of enum.
 *
 * @author yyunikov
 */
public final class EnumValue<E extends Enum<E>> {

    private final Class<E> enumClass;

    private EnumValue(final Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    /**
     * Returns a {@link EnumValue} object for enum class.
     *
     * @param enumClass non-null enumeration class
     * @param <E> enumeration class as type
     * @return {@link EnumValue} object for enum class
     */
    public static <E extends Enum<E>> EnumValue<E> of(final Class<E> enumClass) {
        Objects.requireNonNull(enumClass);
        return new EnumValue<>(enumClass);
    }

    /**
     * Finds all enum values which match the predicate.
     *
     * @param enumFieldFunction predicate
     * @return set of all enum values which match the predicate
     */
    public Set<E> allByPredicate(final Predicate<E> enumFieldFunction) {
        return streamByPredicate(enumFieldFunction)
                        .collect(Collectors.toSet());
    }

    /**
     * Finds first enumeration which matches by name.
     *
     * @param name name of the enum value
     * @param <T> enum class
     * @return {@link java.util.Optional} enum which matches the name
     */
    public <T> Optional<E> firstByName(final T name) {
        return firstByPredicate(enumObj -> enumObj.name().equals(name));
    }

    /**
     * Finds first enumeration which matches by predicate.
     *
     * @param enumFieldFunction predicate for finding enum value
     * @return {@link java.util.Optional} enum which matches by predicate
     */
    public Optional<E> firstByPredicate(final Predicate<E> enumFieldFunction) {
        return streamByPredicate(enumFieldFunction)
                .findFirst();
    }

    /**
     * Finds all enum values which match the predicate.
     *
     * @param enumFieldFunction predicate
     * @return stream of all enum values which match the predicate
     */
    public Stream<E> streamByPredicate(final Predicate<E> enumFieldFunction) {
        return EnumSet.allOf(enumClass)
                .stream()
                .filter(enumFieldFunction);
    }
}
