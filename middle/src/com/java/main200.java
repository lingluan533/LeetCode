package com.java;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/1/13 22:58
 */
public class main200 {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int [] temp =null;
        int count = 0;
        for(int i =0;i<m;i++){
            for (int j = 0;j<n;j++){
                if(grid[i][j] == '1'){
                    count ++;
                    infect(grid,i,j,m,n);
                }
            }
        }
    return count;
    }

    private void infect(char[][] grid, int i, int j,int m,int n ) {
        if(i ==  m || j == n || i<0 || j<0|| grid[i][j]!='1'){
            return ;
        }
            grid[i][j] = '2';

        infect(grid,i-1,j,m,n);
        infect(grid,i,j-1,m,n);
        infect(grid,i+1,j,m,n);
        infect(grid,i,j+1,m,n);
    }
}
