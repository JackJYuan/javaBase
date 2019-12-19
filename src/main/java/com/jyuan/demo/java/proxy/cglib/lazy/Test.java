package com.jyuan.demo.java.proxy.cglib.lazy;


public class Test {

    public static void main(String... args){
        LazyBean lazyBean = new LazyBean("张大壮", 26);
        System.out.println(lazyBean.getPropertyBean());
        System.out.println(lazyBean.getPropertyBean());
    }
}
