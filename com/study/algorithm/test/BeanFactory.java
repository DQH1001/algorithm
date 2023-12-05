package com.study.algorithm.test;

public class BeanFactory {
    private static final Object lock = new Object();
    private static SingleTon singleTon;

    public static SingleTon getSingleTon() {
        if (singleTon == null) {
            synchronized (lock) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
