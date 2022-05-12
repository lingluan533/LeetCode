package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/4/29 16:45
 */
public class main17401 {
    public  int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int dp[][] = new int[row+1][col+1];
        for (int i = 0;i<=row;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[row][col -1] = dp[row-1][col] = 1;

        for(int i = row -1 ;i>=0;i--){
            for(int j = col - 1;j>=0;j--){
                int tem = Math.min(dp[i][j+1],dp[i+1][j]);
                dp[i][j] = Math.max(1, tem - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
