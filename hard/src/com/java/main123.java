package com.java;

/**
 * @author: zms
 * @create: 2022/4/27 10:26
 */
public class main123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //dp[i][j][k] 表示在 0-i的区间内交易了j次，在i天结束为k（1持有股票/0不持有股票）状态时，最大的收益数
        int dp[][][] = new int[len][2][2];

        dp[0][0][0] = 0;
        dp[0][1][0] = 0; //进行了一次交易并且结束时不持有股票，说明当天就卖了，收益为0
        dp[0][1][1] = -1*prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = Integer.MIN_VALUE;

        for(int i = 1; i<len ; i++){
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], - prices[i]);
            dp[i][2][0] = Math.max(dp[i-1][2][0],dp[i-1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i-1][1][0] - prices[i]);

        }
        return Math.max(dp[len-1][1][0],dp[len-1][2][0]);

    }
}
