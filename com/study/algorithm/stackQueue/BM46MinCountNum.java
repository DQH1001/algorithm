package com.study.algorithm.stackQueue;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 * 数据范围：0≤k,n≤10000，数组中每个数的大小0≤val≤1000
 * 要求：空间复杂度 O(n)，时间复杂度 O(nlogk)
 */
public class BM46MinCountNum {
    // 方法一：排序
    // 直接排序，然后取前k小数据。
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k == 0 || k > input.length) {
            return list;
        }

        List<Integer> collect = Arrays.stream(input).sorted().boxed().collect(Collectors.toList());
        list = new ArrayList<>(collect.subList(0, k));

        //  返回的是List类型
        return list;
    }

    /**
     * 方法二
     * 堆排序（推荐使用）
     * 知识点：优先队列
     * 优先队列即PriorityQueue，是一种内置的机遇堆排序的容器，分为大顶堆与小顶堆，大顶堆的堆顶为最大元素，
     * 其余更小的元素在堆下方，小顶堆与其刚好相反。且因为容器内部的次序基于堆排序，因此每次插入元素时间复杂度都是O(log2 n)，
     * 而每次取出堆顶元素都是直接取出。
     * <p>
     * 思路：
     * <p>
     * 要找到最小的k个元素，只需要准备k个数字，之后每次遇到一个数字能够快速的与这k个数字中最大的值比较，每次将最大的值替换掉，
     * 那么最后剩余的就是k个最小的数字了。
     * <p>
     * 如何快速比较k个数字的最大值，并每次替换成较小的新数字呢？我们可以考虑使用优先队列（大根堆），只要限制堆的大小为k，
     * 那么堆顶就是k个数字的中最大值，如果需要替换，将这个最大值拿出，加入新的元素就好了。
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_Two(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k == 0 || k > input.length) {
            return list;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (priorityQueue.peek() > input[i]) {
                priorityQueue.poll();
                priorityQueue.offer(input[i]);
            }
        }
        list.addAll(priorityQueue);
        return list;
    }

    /**
     * 快排思想
     * 对数组[l, r]一次快排partition过程可得到，[l, p), p, [p+1, r)三个区间,[l,p)为小于等于p的值
     * [p+1,r)为大于等于p的值。
     * 然后再判断p，利用二分法
     * <p>
     * 1. 如果[l,p), p，也就是p+1个元素（因为下标从0开始），如果p+1 == k, 找到答案
     * 2. 如果p+1 < k, 说明答案在[p+1, r)区间内，
     * 3. 如果p+1 > k , 说明答案在[l, p)内
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_Three(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k == 0 || k > input.length) {
            return list;
        }
        quickSort(input, list, k, 0, input.length - 1);
        return list;
    }

    private void quickSort(int[] input, ArrayList<Integer> res, int k, int left, int right) {
        if (left > right) {
            return;
        }
        int start = left;
        int end = right;
        while (left < right) {
            while (input[right] >= input[start] && left < right) {
                right--;
            }
            while (input[left] <= input[start] && left < right) {
                left++;
            }
            swap(input, left, right);
        }
        swap(input, left, start);

        if (left + 1 < k) {
            quickSort(input, res, k, left + 1, end);
        } else if (left + 1 > k) {
            quickSort(input, res, k, start, left - 1);
        } else {
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        BM46MinCountNum b = new BM46MinCountNum();
        System.out.println(b.GetLeastNumbers_Solution(arr, 8));
        System.out.println(b.GetLeastNumbers_Solution_Two(arr, 8));
        System.out.println(b.GetLeastNumbers_Solution_Three(arr, 8));
    }
}
