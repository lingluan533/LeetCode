package com.java;

/**
 * @author: zms
 * @create: 2022/4/27 17:09
 */
public class main309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[len][3]; //dp[i][0] 表示 i天结束不持有股票 且不在冷冻期
                                        //dp[i][1] 表示 i天结束不持有股票 且在冷冻期
                                        //dp[i][2] 表示 i天结束持有股票的最大收益

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        for(int i = 1;i<len;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][2] + prices[i]; //今天卖，明天就是冷冻期
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0] - prices[i]);
        }
        return Math.max(dp[len-1][0],dp[len][1]);
    }
}
