package com.alpaca.example.annotation;

import java.lang.annotation.*;

/**
 * @author Lien6o
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Sql {

    String value();

}
