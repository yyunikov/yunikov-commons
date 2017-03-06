package com.yunikov.commons.junit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Repeats the the same test specified number of times.
 *
 * @author yyunikov
 * @since 1.5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Repeat {
    int times();
}
