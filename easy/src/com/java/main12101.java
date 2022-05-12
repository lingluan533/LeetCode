package com.java;

/**
 * @author: zms
 * @create: 2022/1/4 10:11
 */
public class main12101 {
    public int maxProfit(int[] prices) {
        //dp[0][] 表示今天不持有股票的最大的收益 （今天卖掉/昨天就卖了 ）
        //dp[1][] 表示今天持有股票的最大收益 （今天买/昨天就买了今天没卖）
        int dp[][] = new  int[2][prices.length];
        dp[1][0] = -1*prices[0];

        for(int i = 1;i<prices.length;i++){
            dp[0][i] = Math.max(prices[i] + dp[1][i-1],dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-1],-1*prices[i]);

        }

        return    dp[0][prices.length-1] ;
    }
}
