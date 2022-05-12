package com.java;

/**
 * @author: zms
 * @create: 2022/4/27 16:07
 */
public class main714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        //dp[i][j] 表示0-i天，并且第i天结束的时候持有股票的状态为j（0：不持有/ 1：持有）的时候的最大收益
        int dp[][] = new int[len+1][2];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        for(int i = 1; i <= len ;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[len][0];

    }
}
