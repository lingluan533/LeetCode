package com.java;

/**
 * @author: zms
 * @create: 2022/8/13 16:23
 */
public class main12105 {
    public int maxProfit(int[] prices) {
        // m每天有两种状态 一个是持有股票的利润（为负数）
        //                一个是不持有的利润（由昨天的持有今天卖掉  或者 昨天也不持有）

        int dp[][] = new int[prices.length][2];
        dp[0][0] = -1 * prices[0];
        dp[0][1] = 0;
        for(int i = 1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],-1*prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i][0] + prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
