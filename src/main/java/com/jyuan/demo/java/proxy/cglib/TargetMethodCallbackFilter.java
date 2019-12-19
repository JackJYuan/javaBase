package com.jyuan.demo.java.proxy.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * 回调方法过滤
 * */
public class TargetMethodCallbackFilter implements CallbackFilter {

    /**
     * (1)callback1：方法拦截器
     * (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
     * (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
     */
    private static Callback[] callbacks = {
            new TargetInterceptor(),
            new TargetResultFixed(),
            NoOp.INSTANCE
    };
    public static Callback[] getCallbacks() {
        return callbacks;
    }

    /**
     * 过滤方法
     * 返回的值为数字，代表了Callback数组中的索引位置，要到用的Callback
     */
    @Override
    public int accept(Method method) {
        if(method.getName().equals("method1")) {
            //System.out.println("filter method1 index : 0");
            return 0;
        }

        if(method.getName().equals("method2")) {
            //System.out.println("filter method1 index : 1");
            return 1;
        }

        if(method.getName().equals("method3")) {
            //System.out.println("filter method1 index : 2");
            return 2;
        }

        return 0;
    }


}
