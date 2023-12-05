package com.study.algorithm.stackQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * <p>
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * <p>
 * 窗口大于数组长度或窗口长度为0的时候，返回空。
 * <p>
 * 数据范围：1≤n≤10000，0≤size≤10000，数组中每个元素的值满足 ∣val∣≤10000
 * 要求：空间复杂度 O(n)，时间复杂度 O(n)
 */
public class BM45SlidingWindowMaxNum {
    // 方法一：枚举
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> data = new ArrayList<>();
        if (num.length < 1 || num.length < size || size == 0) {
            return data;
        }
        for (int i = 0; i + size - 1 < num.length; i++) {
            int j = i + size - 1;
            int maxVal = num[j];
            for (int k = i; k < j; k++) {
                maxVal = Math.max(maxVal, num[k]);
            }
            data.add(maxVal);
        }
        return data;
    }

    // 方法二：单调队列
    public ArrayList<Integer> maxInWindowsTwo(int[] num, int size) {
        ArrayList<Integer> data = new ArrayList<>();
        if (num.length < 1 || num.length < size || size == 0) {
            return data;
        }

        // 建立一个双端队列，从左往右遍历，当前元素比之前的大，则把之前的取出来
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // 先遍历第一个窗口，遍历完arrayDeque只会有第一个窗口的最大值
        for (int i = 0; i < size; i++) {
            while (!arrayDeque.isEmpty() && num[arrayDeque.peekLast()] < num[i]) {
                arrayDeque.pollLast();
            }
            arrayDeque.add(i);
        }

        // size之前的已经遍历过了，从size开始遍历后面的
        for (int i = size; i < num.length; i++) {
            // 存下上一个窗口的最大值
            data.add(num[arrayDeque.peekFirst()]);

            // 窗口向右移动，取出之前下标超出的元素
            while (!arrayDeque.isEmpty() && arrayDeque.peekFirst() < i - size + 1) {
                arrayDeque.pollFirst();
            }

            // 与之前的逻辑一样，当前元素比之前的大，则把之前的取出来，比上一个小，则放进去
            while (!arrayDeque.isEmpty() && num[arrayDeque.peekLast()] < num[i]) {
                arrayDeque.pollLast();
            }
            arrayDeque.add(i);
        }

        // 存入最后一次遍历的窗口的最大值
        data.add(num[arrayDeque.pollFirst()]);

        return data;
    }

    public static void main(String[] args) {
        int[] num = new int[]{10, 14, 12, 11, 25, 34, 34, 23};
        int size = 3;
        BM45SlidingWindowMaxNum b = new BM45SlidingWindowMaxNum();
        ArrayList<Integer> integers = b.maxInWindows(num, size);
        System.out.println(integers);
        integers = b.maxInWindowsTwo(num, size);
        System.out.println(integers);
    }
}
