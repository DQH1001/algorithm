package com.study.algorithm.sort;

/**
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * <p>
 * 给定 target = 3，返回 false。
 * <p>
 * 数据范围：矩阵的长宽满足0≤n,m≤500， 矩阵中的值满足0≤val≤10^9
 * 进阶：空间复杂度O(1)，时间复杂度O(n+m)
 */
public class BM18 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int top = 0;
        int bottom = array.length - 1;
        int lastIndex = array[0].length -1;
        while (top <= bottom) {
            int mid = (top + bottom) /2;
            if (target<array[mid][0]){
                bottom = mid -1;
            } else if (target > array[mid][lastIndex]) {
                top = mid+1;
            } else {
                // array[mid][0]<= target && target <= array[mid][lastIndex]
                int result = BM18.search(array[mid], target);
                if (result == -1) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

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
}
