package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/9/3 16:06
 */
public class main61102 {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
    }

    public static int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i + 1; j--) {
                int left = i + 1;
                int right = j - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[i] + nums[mid] <= nums[j]) {// 两边之和小于等于第三边
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                count += j - left;
            }
        }
        return count;

    }
}
