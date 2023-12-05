package com.study.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 1, 2, 2, 1, 1, 1, 8, 9, 57, 34, 365, 2231, 13, 54, 43, 5446, 57, 67, 1, 2, 687, 23, 234, 23};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quickSort(int[] arr, int currentLeftIndex, int currentRightIndex) {
        if (currentLeftIndex >= currentRightIndex) {
            return;
        }

        // 设左边第一个为中间值
        int midNum = arr[currentLeftIndex];
        int begin = currentLeftIndex;
        int end = currentRightIndex;
        while (currentLeftIndex < currentRightIndex) {
            // 右边指针从右向左遍历，找到比midNum小的为止
            while (arr[currentRightIndex] >= midNum && currentLeftIndex < currentRightIndex) {
                currentRightIndex--;
            }

            // 左边指针从左向右遍历，找到比midNum大的为止
            while (arr[currentLeftIndex] <= midNum && currentLeftIndex < currentRightIndex) {
                currentLeftIndex++;
            }

            if (currentLeftIndex < currentRightIndex) {
                int tempNum = arr[currentLeftIndex];
                arr[currentLeftIndex] = arr[currentRightIndex];
                arr[currentRightIndex] = tempNum;
            }
        }

        // 最后将midNum与当前位置交换
        arr[begin] = arr[currentLeftIndex];
        arr[currentLeftIndex] = midNum;

        // 经过while完成了一次基于midNum的一次排序，mid两侧的数据还需递归排序
        quickSort(arr, begin, currentLeftIndex - 1);
        quickSort(arr, currentLeftIndex + 1, end);
    }
}
