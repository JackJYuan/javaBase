package com.jyuan.demo.java.proxy.jdk;

import com.jyuan.demo.java.proxy.jdk.impl.CarActionImpl;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String... args){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true"); // 设置系统属性，把生成的代理类写入到文件

        CarAction carActionProxy =
                (CarAction) Proxy.newProxyInstance(CarAction.class.getClassLoader(),
                        new Class[]{CarAction.class},
                        new NoTargetInvocationHandler());

        System.out.println("---------------NoTargetInvocationHandler-----------");
        carActionProxy.backward(100);
        carActionProxy.turnLeft(50);
        carActionProxy.stop();

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true"); // 设置系统属性，把生成的代理类写入到文件
        System.out.println("---------------TargetInvocationHandler-----------");
        CarAction carActionProxy2 =
                (CarAction) Proxy.newProxyInstance(CarAction.class.getClassLoader(),
                        new Class[]{CarAction.class},
                        new TargetInvocationHandler(new CarActionImpl()));
        carActionProxy2.backward(100);
        carActionProxy2.turnLeft(50);
        carActionProxy2.stop();
    }
}
