package com.alpaca.spring;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Lien6o
 */
public class AlpacaFactoryBean<T> implements FactoryBean<T> {

    private Class<T> targetClass;

    private Class<? extends InvocationHandler> invocationHandler;

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() throws Exception {
        InvocationHandler invocationHandler = this.invocationHandler.getDeclaredConstructor().newInstance();
        Object proxyInstance = Proxy.newProxyInstance(targetClass.getClassLoader(), new Class[]{targetClass}, invocationHandler);
        return (T) proxyInstance;
    }

    @Override
    public Class<T> getObjectType() {
        return targetClass;
    }

    public void setTargetClass(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    public void setInvocationHandler(Class<? extends InvocationHandler> invocationHandler) {
        this.invocationHandler = invocationHandler;
    }
}
