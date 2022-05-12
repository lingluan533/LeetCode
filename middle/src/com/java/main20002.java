package com.java;

/**
 * @author: zms
 * @create: 2022/3/19 20:53
 */
public class main20002 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == '1'){
                    count ++;
                    dfs(i,j,grid);
                }
            }
        }
        return  count;
    }
    public int flag[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(int i, int j, char[][] grid) {
        if(i<0 || i>=grid.length|| j<0 || j>grid[0].length) return;
        if(grid[i][j] != '1'){
            return ;
        }
        grid[i][j] = '0';
        for(int k = 0;k<4;k++){
            dfs(i+flag[k][0],j+flag[k][1],grid);
        }
    }
}
