package com.alpaca.annoatation;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;

/**
 * @author Lien6o
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Alpaca {

    Class<? extends InvocationHandler> invocationHandler();

}
