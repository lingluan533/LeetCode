package com.java;

import java.util.Random;

/**
 * @author: zms
 * @create: 2022/10/29 22:45
 */
public class main21504 {
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k; // 目标：第k个最大值  借助了快排每次都可以确定一个值的最终位置来逼近
        while (left < right) {
            int index = parition(left, right, nums);
            if (index == target) {
                return nums[index];
            } else if (index < target) { // 本次确定的最终位置小于目标 则应在右边寻找
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return nums[left];
    }

    private static int parition(int left, int right, int[] nums) {
        Random random = new Random(System.currentTimeMillis());
        int r = random.nextInt(right - left + 1) + left;  // random生成 [0,right-left]  这样就能得到随机的left到right之间的一个下标了
        int privot = nums[r];
        int t = nums[left];
        nums[left] = privot;
        nums[r] = t;
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= privot) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i < j && nums[i] < privot) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = privot;
        return i;
    }
}
