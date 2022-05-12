package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2021/12/31 11:38
 */
public class main53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp[] = new int [nums.length];
        if(len ==1) return nums[0];
       dp  =  Arrays.copyOf(nums,len);
       int max = dp[0];
        for(int i =1;i<len;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }
    return max;
    }
    }
