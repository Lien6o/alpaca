package com.alpaca.proxy;

import com.alpaca.annoatation.Get;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Lien6o
 */
public class AlpacaProxy implements InvocationHandler {

    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Throwable {
        // you can do anything hei hei hei! so this is a extent point
        Get annotation = method.getAnnotation(Get.class);
        return annotation.value();
    }
}
