package com.jyuan.demo.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TargetInvocationHandler implements InvocationHandler {

    private CarAction target;

    public TargetInvocationHandler(CarAction carAction){
        this.target = carAction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("before invoke");
        return method.invoke(target, args);
    }
}
