package com.study.algorithm.test;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(3);
        for (Integer i : stack) {
            System.out.println(i);
        }
        System.out.println("for遍历结束：" + stack.size());
        Iterator<Integer> integerIterator = stack.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
        System.out.println("Iterator遍历结束：" + stack.size());
        stack.remove(0);
        stack.remove(0);
        stack.remove(0);
        stack.remove(0);
        System.out.println(stack.add(1));
        System.out.println(stack.add(2));
        System.out.println(stack.add(3));
        System.out.println(stack.add(4));
        System.out.println(stack.add(5));
        stack.remove(new Integer(1));
        System.out.println(stack.capacity());
        stack.add(6);
        Integer a[] = new Integer[10];
        stack.copyInto(a);
        Arrays.stream(a).forEach(System.out::print);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("while遍历结束：" + stack.size());
    }
}
