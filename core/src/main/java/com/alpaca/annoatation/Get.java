package com.alpaca.annoatation;

import java.lang.annotation.*;

/**
 * @author Lien6o
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Get {

    String value() default "";
}
