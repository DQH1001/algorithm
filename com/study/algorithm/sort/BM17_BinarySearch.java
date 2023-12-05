package com.study.algorithm.sort;

/**
 * 二分搜索
 */
public class BM17_BinarySearch {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 4, 6, 10, 13, 14};
        System.out.println(BM17_BinarySearch.search(arr, 14));
    }
}
