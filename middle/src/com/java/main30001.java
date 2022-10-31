package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/10/19 9:55
 */
public class main30001 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int max = 1;
        int dp[] = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
}
