package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/3/2 11:40
 */
public class main47 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(i==0&& j ==0) continue;
                if(i==0 || j == row-1){
                    dp[i][j]  = dp[i][j-1] + grid[i][j];
                }else if(j==0 || j == col -1){
                    dp[i][j]  = dp[i-1][j] + grid[i][j];
                }else{
                    dp[i][j]  = Integer.max(dp[i-1][j]+grid[i][j] ,dp[i][j-1]+grid[i][j]);
                }

            }
        }
        return dp[row-1][col-1];
    }
}
