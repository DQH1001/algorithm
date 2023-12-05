package com.study.algorithm.thread;

import java.util.concurrent.CountDownLatch;

public class NumberThread {

    public static final String lock = "lock";

    public static void main(String[] args) {
        CountDownLatch a = new CountDownLatch(1);

        Thread numThread = new Thread(()->{
            synchronized (lock) {
                a.countDown();
                int[] nums = new int[]{1,2,3};
                for (int num : nums) {
                    System.out.print(num);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread alphaThread = new Thread(()->{
            synchronized (lock) {
                char[] chars = new char[]{'A','B','C'};
                for (char c : chars) {
                    System.out.print(c);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        numThread.start();
        try {
            a.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alphaThread.start();
    }
}
