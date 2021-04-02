package com.alpaca.example.proxy;


import com.alpaca.example.annotation.Get;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Lien6o
 */
public class AlpacaHttpProxy implements InvocationHandler {

    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Throwable {
        // you can do anything hei hei hei! so this is a extent point

        Get annotation = method.getAnnotation(Get.class);
        return annotation.value();
    }
}
