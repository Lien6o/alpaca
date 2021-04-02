package com.alpaca.example.annotation;

import java.lang.annotation.*;

/**
 * @author Lien6o
 * eg. http request
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Get {

    String value() default "";
}
