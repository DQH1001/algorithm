package com.study.algorithm.thread;

/**
 * 多生产者多消费者模型
 */
public class ProductThread {
    private static volatile int count = 0;
    private static final Object lock = new Object();

    static class Product extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count >= 10) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        ++count;
                        System.out.println(Thread.currentThread().getName() + "生产一次后：" + count);
                        lock.notifyAll();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consume extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count <= 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        --count;
                        System.out.println(Thread.currentThread().getName() + "消费一次后：" + count);
                        lock.notifyAll();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Consume c1 = new Consume();
        Consume c2 = new Consume();
        Consume c3 = new Consume();
        p1.setName("p1");
        c1.setName("c1");
        p2.setName("p2");
        c2.setName("c2");
        p3.setName("p3");
        c3.setName("c3");
        p1.start();
        c1.start();
        p2.start();
        c2.start();
        p3.start();
        c3.start();
    }
}
