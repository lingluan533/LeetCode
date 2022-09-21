package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/9/3 15:30
 */
public class main611 {
    public static void main(String[] args) {

    }

    public int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j + 1 < len && nums[i] + nums[j] < nums[j + 1]) {
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
