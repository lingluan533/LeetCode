package com.java.week306;

/**
 * @author: zms
 * @create: 2022/8/14 10:25
 */
public class main4 {
    public int[][] largestLocal(int[][] grid) {
        int row  = grid.length;
        int col = grid[0].length;
        int [][]res = new int[row -2 ][col-2];
        for(int i = 0;i<row-1;i++){
            for(int j = 0;j<col-2;j++){
                res[i][j] = GetMax(i,j,grid);
            }
        }
        return res;
    }
    public int GetMax(int r,int c,int [][] a){
        int max = a[r][c];
        for (int i = r;i<r+3;i++){
            for(int j = c;j<c+3;j++){
                max =Math.max(max,a[i][j]);
            }
        }
        return max;
    }
}
