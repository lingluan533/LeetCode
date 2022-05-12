package com.java;

/**
 * @author: zms
 * @create: 2022/4/27 11:46
 */
public class main188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len /2){
            return greedy(prices);
        }
            //dp[i][j][k] 表示在i天的范围内 完成了j笔交易 且i天结束时持有股票状态为k（0：不持有 / 1：持有）的时候的最大收益
        int dp[][][] = new int[len+1][k+1][2];
        for(int i = 0;i<=len;i++){
            for(int j = 0;j<=k;j++){
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }
        for(int i = 1;i<=len;i++){
            for(int j = 1;j<=k;j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i-1]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1]);
            }
        }
        return dp[len][k][0];
    }

    private int greedy(int[] prices) {
        int len = prices.length;
        int sum = 0;
        for(int i = 1;i<len;i++){
            int cha = prices[i] - prices[i-1];
            if (cha > 0) sum += cha;
        }
        return  sum;
    }
}
