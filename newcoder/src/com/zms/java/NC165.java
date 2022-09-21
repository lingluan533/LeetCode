package com.zms.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/9/12 11:08
 */
public class NC165 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        System.out.println(LCS("abcde", "bdcaaa"));
    }

    public static int LCS(String s1, String s2) {
        // write code here
        int m = s1.length();
        int n = s2.length();
        int max = 0;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return max;

    }
}
