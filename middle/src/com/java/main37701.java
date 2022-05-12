package com.java;

/**
 * @author: zms
 * @create: 2022/4/22 20:36
 */
public class main37701 {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 1 ;i<= target;i++){
            for(int num : nums){
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
