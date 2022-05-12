package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/9 10:37
 */
public class main417 {
    public static void main(String[] args) {
        int h [][] = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = pacificAtlantic(h);
        for (List<Integer> list : lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
   static int heights [][];
    static boolean pacAble[][];
    static boolean atlAble[][];
    static List<List<Integer>> res;
    static int m,n;
    static boolean pacvis[][];
    static boolean atvis[][];
    public static List<List<Integer>> pacificAtlantic(int[][] height) {
        res = new ArrayList<>();
        int ms = height.length;
        int ns = height[0].length;
        m = ms;
        n = ns;
        pacAble = new boolean[m][n];
        atlAble = new boolean[m][n];
        heights = height;
        for(int i = 0;i<n;i++){
          dfs(pacAble,0,i);
          dfs(atlAble,m-1,i);
        }
        for(int i = 0;i<m;i++){
            dfs(pacAble,i,0);
            dfs(atlAble,i,n-1);
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(pacAble[i][j]  &&  atlAble[i][j] ){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    static  int [][] flag = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private static void dfs(boolean[][] arr, int x, int y) {
        arr[x][y] = true;
        for (int i = 0;i<4;i++){
            int newx = x + flag[i][0];
            int newy = y + flag[i][1];
            if(newx == m || newy == n || newx <0 || newy <0){
                continue;
            }
            if(heights[x][y] <= heights[newx][newy] && arr[newx][newy] == false){
                dfs(arr,newx,newy);
            }
        }
    }
}
