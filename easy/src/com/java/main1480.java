package com.java;

/**
 * @author: zms
 * @create: 2022/8/7 21:20
 */
public class main1480 {
    public int[] runningSum(int[] nums) {
            int len = nums.length;
            int dp[] = new int[len];
            dp[0] = nums[0];
            for (int i = 1 ;i<len;i++){
                dp[i] = dp[i-1] + nums[i];
            }
            return dp;
    }
}
