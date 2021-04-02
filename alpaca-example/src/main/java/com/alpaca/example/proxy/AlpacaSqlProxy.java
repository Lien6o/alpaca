package com.alpaca.example.proxy;

import com.alpaca.example.annotation.Sql;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Lien6o
 */
public class AlpacaSqlProxy implements InvocationHandler {
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        Sql annotation = method.getAnnotation(Sql.class);
        return annotation.value();
    }
}
