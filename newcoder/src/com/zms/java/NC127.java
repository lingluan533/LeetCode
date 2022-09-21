package com.zms.java;

/**
 * @author: zms
 * @create: 2022/9/12 9:42
 */
public class NC127 {
    public static void main(String[] args) {
        LCS("1AB2345CD", "12345EF");
    }

    public static String LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        dp[0][0] = 0;
        int max = 0;
        int endIndex = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        endIndex = i;
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }


        return str1.substring(endIndex - max + 1, endIndex + 1);
    }
}
