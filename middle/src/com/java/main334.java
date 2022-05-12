package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/1/12 22:36
 */
public class main334 {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if(len < 3 ) return false;
        int dp[] = new int [len];
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                   dp[i] = Math.max(dp[i],dp[j]+1);
                   if(dp[i] ==3 ) return true;
                }
            }
        }
            return false;
    }
}
