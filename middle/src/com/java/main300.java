package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/3/15 16:26
 */
public class main300 {
    public int lengthOfLIS(int[] nums) {
        int dp []  = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i = 1;i< nums.length;i++){
            for(int j = 0;j<=i-1;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max==0? 1:max;
    }

}
