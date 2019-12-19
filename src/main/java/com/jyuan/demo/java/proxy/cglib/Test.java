package com.jyuan.demo.java.proxy.cglib;

import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;

public class Test {

    public static void main(String... args){

        System.out.println("----------------------无方法拦截器--------------------");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject = (TargetObject) enhancer.create();

        System.out.println(targetObject);
        System.out.println(targetObject.method1("mmm1"));
        System.out.println(targetObject.method2(100));
        System.out.println(targetObject.method3(200));
        System.out.println(targetObject.getValue());

        System.out.println("----------------------增加方法拦截器--------------------");
        Enhancer enhancer2 = new Enhancer();
        enhancer2.setSuperclass(TargetObject.class);
        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();
        enhancer2.setCallbacks(TargetMethodCallbackFilter.getCallbacks());
        enhancer2.setCallbackFilter(callbackFilter);
        TargetObject targetObject2 = (TargetObject) enhancer2.create();

        targetObject2.method1("mmm2");
        targetObject2.method2(100);
        targetObject2.method3(200);

    }
}
