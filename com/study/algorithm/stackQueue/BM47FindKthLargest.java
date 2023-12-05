package com.study.algorithm.stackQueue;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
 * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
 * 要求：时间复杂度 O(nlogn)，空间复杂度 O(1)
 * 数据范围：0≤n≤1000，1≤K≤n，数组中每个元素满足 0≤val≤10000000
 * 示例1
 * 输入：[1,3,5,2,2],5,3
 * 返回值：2
 */
public class BM47FindKthLargest {
    public int findKth(int[] a, int n, int K) {
        if (n == 0) {
            return 0;
        }
        quickSort(a, 0, n - 1, K);
        return a[n - K];
    }

    private static void quickSort(int[] a, int l, int r, int K) {
        if (l > r) {
            return;
        }

        int start = l;
        int end = r;
        while (l < r) {
            while (l < r && a[r] >= a[start]) {
                r--;
            }
            while (l < r && a[l] <= a[start]) {
                l++;
            }
            swap(a, l, r);
        }
        swap(a, start, l);

        if (l < a.length - K) {
            quickSort(a, l + 1, end, K);
        } else if (l > a.length - K) {
            quickSort(a, start, l - 1, K);
        } else {
            return;
        }
    }

    private static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void main(String[] args) {
        BM47FindKthLargest b = new BM47FindKthLargest();
        int[] a = new int[]{10, 10, 9, 13, 8, 7, 5, 6, 4, 3, 4, 2};
        System.out.println(b.findKth(a, 12, 7));
    }
}
