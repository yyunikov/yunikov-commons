package com.yunikov.commons;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contains methods for working with specific enumeration, mainly for quick finding different instances of enum.
 *
 * @author yyunikov
 */
public final class EnumValues<E extends Enum<E>> {

    private final Class<E> enumClass;

    private EnumValues(final Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    /**
     * Returns a {@link EnumValues} object for enum class.
     *
     * @param enumClass non-null enumeration class
     * @param <E>       enumeration class as type
     * @return {@link EnumValues} object for enum class
     */
    public static <E extends Enum<E>> EnumValues<E> of(final Class<E> enumClass) {
        Objects.requireNonNull(enumClass);
        return new EnumValues<>(enumClass);
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
     * Constructs a string from a enum names using pipe symbol. For example ONE|TWO|THREE.
     * Useful when making validations on enumeration.
     *
     * @return enum names concatenated with pipe symbol
     */
    public String concat() {
        return concat(Enum::name);
    }

    /**
     * Constructs a string from a enum by a function using pipe symbol. For example ONE|TWO|THREE.
     * Useful when making validations on enumeration.
     *
     * @param toStringConsumer function which converts a enum to a string
     * @return enum values concatenated with pipe symbol
     */
    public String concat(final Function<E, String> toStringConsumer) {
        return concat(toStringConsumer, "|");
    }

    /**
     * Constructs a string from a enum by a function using provided symbol. For example ONE&TWO&THREE.
     *
     * @param toStringConsumer function which converts a enum to a string
     * @param symbol           symbol for concatenation of strings
     * @return enum values concatenated with pipe symbol
     */
    public String concat(final Function<E, String> toStringConsumer, final String symbol) {
        final StringBuilder sb = new StringBuilder();
        EnumSet.allOf(enumClass)
                .forEach(enumValue -> sb.append(toStringConsumer.apply(enumValue)).append(symbol));
        return sb.toString().substring(0, sb.toString().length() - symbol.length());
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof EnumValues) {
            return Objects.equals(enumClass, ((EnumValues) object).enumClass);
        }

        return false;
    }

    /**
     * Finds first enumeration which matches by name.
     *
     * @param name name of the enum value
     * @param <T>  enum class
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

    @Override
    public int hashCode() {
        return Objects.hash(enumClass);
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

    /**
     * Transforms a enum to a collection of names. For example [ONE, TWO].
     *
     * @return collection of enum names
     */
    public Collection<String> toNames() {
        return EnumSet.allOf(enumClass)
                .stream()
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
