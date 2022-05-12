package com.java;

/**
 * @author: zms
 * @create: 2022/4/26 11:51
 */
public class main883 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        //俯视图：计数即可
        int fu = 0,ce = 0,zheng = 0;
        for (int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] != 0){
                    fu++;
                }
            }
        }
        //正视图：
        for(int i = 0;i<n;i++){
            int tem = 0;
            for(int j = 0;j<n;j++){
                tem = Math.max(tem, grid[i][j]);
            }
            zheng += tem;
        }

        //侧视图
        for(int i = 0;i<n;i++){
            int tem = 0;
            for(int j = 0;j<n;j++){
                tem = Math.max(tem, grid[j][i]);
            }
            ce += tem;
        }

        return  ce + zheng + fu;


    }
}
