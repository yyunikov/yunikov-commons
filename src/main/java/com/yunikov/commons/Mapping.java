package com.yunikov.commons;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Defines a mapping between source and the target class.
 *
 * @param <SOURCE> source class for mapping
 * @param <TARGET> target class for mapping
 * @since 1.8
 */
@FunctionalInterface
public interface Mapping<SOURCE, TARGET> {

    /**
     * Maps the source object to target object.
     *
     * @param source source object
     * @return created target object
     */
    TARGET map(final SOURCE source);

    /**
     * @see #mapToStream(Stream, Function) mapToStream
     */
    default Stream<TARGET> mapToStream(final Stream<SOURCE> sources) {
        return sources.map(this::map);
    }

    /**
     * Maps the source stream to a target stream.
     *
     * @param sources      stream of source objects
     * @param createMethod method for creating a target object
     * @return stream of target objects
     */
    default Stream<TARGET> mapToStream(final Stream<SOURCE> sources, final Function<SOURCE, TARGET> createMethod) {
        return sources.map(createMethod);
    }

    /**
     * @see #mapToList(Stream, Function) mapToStream
     */
    default List<TARGET> mapToList(final Stream<SOURCE> sources) {
        return mapToStream(sources).collect(Collectors.toList());
    }

    /**
     * Maps the source stream to a target list.
     *
     * @param sources      stream of source objects
     * @param createMethod method for creating a target object
     * @return list of target objects
     */
    default List<TARGET> mapToList(final Stream<SOURCE> sources, final Function<SOURCE, TARGET> createMethod) {
        return mapToStream(sources, createMethod).collect(Collectors.toList());
    }

    /**
     * Maps the source stream to a target map.
     *
     * @param sources      stream of source objects
     * @param createMethod method for creating a target object
     * @return map of target objects
     */
    default Map<SOURCE, TARGET> mapToMap(final Stream<SOURCE> sources, final Function<SOURCE, TARGET> createMethod) {
        return sources.collect(Collectors.toMap(obj -> obj, createMethod));
    }
}

