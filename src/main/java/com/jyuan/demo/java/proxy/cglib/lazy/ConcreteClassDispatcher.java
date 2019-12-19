package com.jyuan.demo.java.proxy.cglib.lazy;

import com.jyuan.demo.java.proxy.cglib.TargetObject;
import org.springframework.cglib.proxy.Dispatcher;

public class ConcreteClassDispatcher implements Dispatcher {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("before Dispatcher...");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setKey("xxx");
        propertyBean.setValue(new TargetObject());
        System.out.println("after Dispatcher...");
        return propertyBean;
    }

}