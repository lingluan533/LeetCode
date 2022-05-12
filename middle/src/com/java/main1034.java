package com.java;

/**
 * @author: zms
 * @create: 2022/3/16 21:08
 */
public class main1034 {
    int ans[][] ;
    int [][] grid;
    int m,n,color;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            this.grid = grid;
             n = grid.length;
             m = grid[0].length;
             this.color = color;
            this.ans = new int[n][m];

            dfs(row,col);

            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(ans[i][j] == 0 ){
                        ans[i][j] = grid[i][j];
                    }
                }
            }
            return ans;
    }
        int [][] flag = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(int row, int col) {
        int cnt = 0;
        for(int i = 0;i<4;i++){
            int newx = flag[0][i] + row;
            int newy = flag[0][i] + col;
            if(newx <0 || newx >= n || newy <0 || newy>=m )continue;
            if (ans[newx][newy] != 0) continue;
            if(grid[newx][newy] == grid[row][col]){ //dfs 下一个位置
                cnt++;
                ans[newx][newy] = -1;
                dfs(newx,newy);
            }
        }
        ans[row][col] = cnt == 4 ? grid[row][col]  :  color;
    }
}
