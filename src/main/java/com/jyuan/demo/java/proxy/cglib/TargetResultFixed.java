package com.jyuan.demo.java.proxy.cglib;

import org.springframework.cglib.proxy.FixedValue;

public class TargetResultFixed implements FixedValue {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("锁定结果 999");
        Object obj = 999;
        return obj;
    }
}
