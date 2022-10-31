package com.java;

/**
 * @author: zms
 * @create: 2022/10/30 22:00
 */
public class main41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] - 1 < len && nums[nums[i] - 1] != nums[i]) {
                int t = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = t;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums[len - 1] + 1;
    }
}
