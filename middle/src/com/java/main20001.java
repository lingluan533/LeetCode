package com.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/1/14 0:13
 */
public class main20001 {
    public static void main(String[] args) {
        char a[][] = new char[4][5];
        a[0] = new char[]{'1','1','1','1','0'};
        a[1] = new char[]{'1','1','0','1','0'};
        a[2] = new char[]{'1','1','0','0','0'};
        a[3] = new char[]{'0','0','0','0','0'};
        System.out.println(numIslands(a));
    }
    public static int numIslands(char[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int row,col;
        int temp [] = null;
        int count = 0;
        for(int i =0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    queue.add(new int[]{i,j});
                    grid[i][j] = '2';
                    while(!queue.isEmpty()){
                        temp = queue.poll();
                        row = temp[0];
                        col = temp[1];
                        //上
                        if(row-1>=0){
                            if(grid[row-1][col] == '1'){
                                queue.add(new int[]{row-1,col});
                                grid[row-1][col] = '2';
                            }

                        }
                        //下
                        if(row +1 <m) {
                            if (grid[row+1][col] == '1') {
                                queue.add(new int[]{row + 1, col});
                                grid[row + 1][col] = '2';

                            }
                        }
                        //左
                        if(col -1 >=0){
                            if(grid[row][col-1] == '1'){
                                queue.add(new int[]{row,col-1});
                                grid[row][col-1] = '2';
                        }

                        }
                        //右
                        if(col +1 <n){
                            if(grid[row][col+1] == '1'){
                                queue.add(new int[]{row,col+1});
                                grid[row][col+1] = '2';
                            }
                        }


                    }
                }
            }
        }
        return count;
    }
}
