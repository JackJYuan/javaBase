package com.jyuan.demo.java.proxy.cglib;

/**
 * 没有实现接口，需要CGlib动态代理的目标类
 */
public class TargetObject {

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;


    public String method1(String paramName) {
        System.out.println("method1 return " + paramName);
        return paramName;
    }

    public int method2(int count) {
        System.out.println("method2 return " + count);
        return count;
    }

    public int method3(int count) {
        System.out.println("method3 return " + count);
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []"+ getClass();
    }
}