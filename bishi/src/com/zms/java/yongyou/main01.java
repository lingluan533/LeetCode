package com.zms.java.yongyou;

/**
 * @author: zms
 * @create: 2022/9/9 20:08
 */
public class main01 {
    public long calculateTotal(int count) {
        // write code here
        int n = count;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        long dp[][] = new long[n + 1][3];
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 0;
        for (int i = 4; i <= n; i++) {
            dp[i][0] = dp[i - 1][2] + dp[i - 1][0];
            dp[i][1] = dp[i][0];
            dp[i][2] = dp[i - 1][1];
        }

        return dp[n][0] + dp[n][1] + dp[n][2];
    }
}
