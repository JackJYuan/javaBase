package com.jyuan.demo.java.proxy.jdk;

/**
 * 汽车行为接口
 * */
public interface CarAction {

    /**
     * 前进
     * @param speed 速度
     * */
    void forward(Integer speed);

    /**
     * 后退
     * @param speed 速度
     * */
    void backward(Integer speed);

    /**
     * 左转
     * @param speed 速度
     * */
    void turnLeft(Integer speed);

    /**
     * 右转
     * @param speed 速度
     * */
    void turnRight(Integer speed);

    /**
     * 停止
     * */
    void stop();

    /**
     * 加速
     * @param value
     * */
    void speedUp(Integer value);


    /**
     * 减速
     * @param value
     * */
    void speedDown(Integer value);
}
