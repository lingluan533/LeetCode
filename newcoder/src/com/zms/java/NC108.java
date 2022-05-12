package com.zms.java;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: zms
 * @create: 2022/3/29 9:55
 */
public class NC108 {
    public int solve (char[][] matrix) {
        // write code here
        //的点点滴滴
        //third commit
        //hot-fix修改
        //master test
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 0) return 0;
        int dp [][] = new int[row][col];
      for(int i = 0;i<row;i++){
          for(int j = 0 ;j<col ;j++){
              dp[i][j] = matrix[i][j] -'0';
          }
      }
      int max = 0;
        for(int i = 1;i<row;i++){
            for(int j = 1; j < col;j++){
                if(dp[i][j] == 0) continue;
                if(dp[i-1][j-1] == 0) continue;
                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max * max;





    }
}
