package com.jyuan.demo.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 没有代理目标的InvocationHandler
 * */
public class NoTargetInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method + "(" + args + ")");
        return null;
    }
}
