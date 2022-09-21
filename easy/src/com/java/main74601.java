package com.java;

/**
 * @author: zms
 * @create: 2022/8/17 20:34
 */
public class main74601 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int dp[] = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2;i<=len;i++){
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[len];
    }
}
