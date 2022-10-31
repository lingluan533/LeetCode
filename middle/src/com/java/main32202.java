package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/10/19 10:48
 */
public class main32202 {
    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0; // 凑出金额为0 所需硬币数量为0；

        for (int i = 1; i <= amount; i++) { //遍历所有的硬币数，看某个硬币所需的最少的硬币个数
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }


        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
