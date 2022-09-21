package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/9/3 15:45
 */
public class main61101 {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
    }

    public static int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;


    }
}
