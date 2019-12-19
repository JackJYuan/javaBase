package com.jyuan.demo.java.proxy.jdk.impl;

import com.jyuan.demo.java.proxy.jdk.CarAction;

public class CarActionImpl implements CarAction {

    private Integer speed = 0;

    /**
     * 前进
     * @param speed 速度
     * */
    @Override
    public void forward(Integer speed){
        this.speed = speed;
        System.out.println("前进，速度" + this.speed);
    }

    /**
     * 后退
     * @param speed 速度
     * */
    @Override
    public void backward(Integer speed){
        this.speed = speed;
        System.out.println("后退，速度" + this.speed);
    }

    /**
     * 左转
     * @param speed 速度
     * */
    @Override
    public void turnLeft(Integer speed){
        this.speed = speed;
        System.out.println("左转，速度" + this.speed);
    }

    /**
     * 右转
     * @param speed 速度
     * */
    @Override
    public void turnRight(Integer speed){
        this.speed = speed;
        System.out.println("右转，速度" + this.speed);
    }

    /**
     * 停止
     * */
    @Override
    public void stop(){
        this.speed = 0;
        System.out.println("停止，速度" + this.speed);
    }

    /**
     * 加速
     * @param value
     * */
    @Override
    public void speedUp(Integer value){
        this.speed += value;
        System.out.println("加速，速度" + this.speed);
    }


    /**
     * 减速
     * @param value
     * */
    @Override
    public void speedDown(Integer value){
        this.speed -= value;
        System.out.println("减速，速度" + this.speed);
    }
}
