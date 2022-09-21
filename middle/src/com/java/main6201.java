package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/8/17 20:57
 */
public class main6201 {
    public int uniquePaths(int m, int n) {
        int dp [][] = new int[m][n];
        Arrays.fill(dp[0],1);
        for (int i = 0;i<=n;i++){
            dp[i][0] = 1;
        }
        for (int i = 1 ; i<m ; i++){
            for (int j = 1;j<n;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
