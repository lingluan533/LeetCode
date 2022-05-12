package com.java;

/**
 * @author: zms
 * @create: 2022/4/24 20:24
 */
public class main59 {
    public int[][] generateMatrix(int n) {
        int res [][] = new int[n][n];
        if(n==1){
            res[0][0] = 1;
            return res;
        }
        boolean [][] vis = new boolean[n][n];
        int i = 0,j = 0;
        int k = 1;
        while (vis[i][j] == false){
            //左
            while (j < n && vis[i][j] == false){
                res[i][j] = k++;
                vis[i][j] = true;
                j++;
            }
            j --;
            i ++;
            //下
            while (i < n && vis[i][j] == false){
                res[i][j] = k++;
                vis[i][j] = true;
                i++;
            }
            i--;
            j--;
            //右
            while (j >=0 && vis[i][j] == false){
                res[i][j] = k++;
                vis[i][j] = true;
                j--;
            }
            i--;
            j++;

            //上
            while (i >= 0 && vis[i][j] == false){
                res[i][j] = k++;
                vis[i][j] = true;
                i--;
            }
            i++;
            j++;
        }
        return  res;
    }
}
