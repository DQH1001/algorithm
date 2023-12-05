package com.study.algorithm.test;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(4);

        queue.remove();
        queue.poll();

        queue.add(3);
        queue.offer(2);

        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println(queue);

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Iterator:" + queue);
        for (Integer i : queue) {
            System.out.println(i);
        }
        System.out.println("for:" + queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println("poll:" + queue);

        queue.remove();
    }
}
