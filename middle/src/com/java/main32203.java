package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/10/30 20:54
 */
public class main32203 {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (Integer coin : coins) {
                if (i >= coin && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }

}
