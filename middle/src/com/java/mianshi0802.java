package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/5 15:48
 */
public class mianshi0802 {
    static List<List<Integer>> path ;
   static int col,row;

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        path = new ArrayList<>();
        col = obstacleGrid[0].length;
        row = obstacleGrid.length;

        dfs(0,0, new boolean[row][col],path,obstacleGrid);
        return path;
    }

    private static boolean dfs(int i, int j, boolean[][] visited, List<List<Integer>> path,int[][] obstacleGrid) {
        if (i >= row  || j >= col ||  obstacleGrid[i][j] == 1 || visited[i][j]){ //如果当前点不合法（出界/已访问过/有障碍物）  则返回false
            return false;
        }
        path.add(Arrays.asList(i,j));//否则 这个点可以经过 将他加入到路径中
        visited[i][j] = true;       //并且置为已访问过

        if(i==row-1 && j==col-1) return true;   //如果当前点走到了最右下角 则说明可以结束算法



        if(dfs(i+1,j,visited,path,obstacleGrid) ){   //否则继续向右或向下探索
            return true;
        }
        if( dfs(i,j+1,visited,path,obstacleGrid)){
            return true;
        }
        //到这里说明既没有到达右下角，因为如果到了会在上面直接返回true  也不能向右或向下走了，因为如果可以会调用上面的两个方向 说明此时是死路了，需要移除到当前的节点。
        //如果已经到了末路，即当前格子没有障碍，但右、下格子都是障碍的话，但还没有到达最后的格子，删掉数组pathList的最后一个元素。并返回false
        path.remove(path.size()-1);
        return false;


    }

    public static void main(String[] args) {

        int [][] a= new int[3][3];
        a[0] = new int[]{0,0,0};
        a[1] = new int[]{0,1,0};
        a[2] = new int[]{0,0,0};
    ArrayList list = new ArrayList();
        pathWithObstacles(a);
    }
}
