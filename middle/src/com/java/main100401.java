package com.java;

/**
 * @author: zms
 * @create: 2022/10/5 10:29
 */
public class main100401 {
    public int longestOnes(int[] nums, int k) {
        int right = 0, left = 0;
        int zero = 0;
        int len = nums.length;
        int max = 0;
        while (right < len) {
            if (nums[right] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[left++] == 0) {
                    zero--;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;

    }
}
