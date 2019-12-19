package com.jyuan.demo.java.reference;

import java.lang.ref.*;
import java.util.ArrayList;

/**
 * 引用测试类
 * */
public class Test {
    private static  final int _1M = 1024;

    /**
     * 强引用测试
     * 会发生OutOfMemoryError
     * */
    private static void strongReference() {
        ArrayList<byte[]> strongReferences = new ArrayList<>();
        try{

            while (true) {
                strongReferences.add(new byte[_1M]);
            }

        } catch (OutOfMemoryError error){
            error.printStackTrace();
        }
    }

    /**
     * 软引用测试
     * 不会发生OutOfMemoryError，内存会维持某个值
     * */
    private static void softReference() {
        ArrayList<SoftReference> softReferences = new ArrayList<>();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        try{
            while (true){
                softReferences.add(new SoftReference<>(new byte[_1M], referenceQueue));
                System.out.println("softReferences length: " + softReferences.size());
            }
        } catch (OutOfMemoryError error){
            error.printStackTrace();
        }
    }

    /**
     * 弱引用测试
     * 不会发生OutOfMemoryError
     * */
    private static void weakReference() {
        ArrayList<WeakReference> weakReferences = new ArrayList<>();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        try{
            while (true) {
                weakReferences.add(new WeakReference<>(new byte[_1M], referenceQueue));
            }
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        }
    }

    /**
     * 虚引用测试
     * */
    private static void phantomReference() {
        ArrayList<PhantomReference<byte[]>> phantomReferences = new ArrayList<>();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        try{
            while (true){
                phantomReferences.add(new PhantomReference<>(new byte[_1M], referenceQueue));
            }
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        }
    }

    /**
     * 引用队列测试
     * */
    private static void referenceQueue() {
        ReferenceQueue<WeakReference<byte[]>> referenceQueue = new ReferenceQueue<>();
        WeakReference<byte[]> weakReference = new WeakReference(new byte[1024], referenceQueue);
        // 后面的 ReferenceQueue.remove 方法会阻塞调用线程，因此开子线程进行操作
        Thread thread = new Thread(() -> {
            try {
                for (Reference pr; (pr = referenceQueue.remove()) != null; ) {
                    System.out.println(pr + " 引用所指向的对象被回收!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /**
         *  因为 ReferenceQueue 对象的 remove 方法是阻塞线程的，因此子线程需设置守护线程，
         * 	否则如果 ReferenceQueue 中没有可取出的引用对象会导致线程一直阻塞，程序不能退出
         */
        thread.setDaemon(true);
        thread.start();
        // 启动垃圾回收动作，将弱引用指向的对象回收
        System.gc();
    }

    public static void main(String... args) {

        // strongReference();
        // softReference();
        // weakReference();
        // phantomReference();
        referenceQueue();
    }


}
