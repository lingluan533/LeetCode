package com.zms.java.kedaxunfei;

import java.util.ArrayList;

/**
 * @author: zms
 * @create: 2022/8/20 23:10
 */
public class main0301 {
    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,1,1,1},{0,0,0,1},{1,1,8,1},{1,1,1,1}};
        ArrayList<Point> points = winMazeGift(maze);
        for (Point p : points){
            System.out.println(p.x+" "+p.y);
        }
    }
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int min = Integer.MAX_VALUE;
     static ArrayList<Point> res =null;
     static int tarx ;
     static int tary ;
     static int maze[][];
    public static ArrayList<Point> winMazeGift (int[][] maze1) {
         res = new ArrayList<>();
         maze = maze1;
         for (int i = 0;i<4;i++){
             for (int j = 0;j<4;j++){
                 if (maze[i][j] == 8){
                     tarx = i;
                     tary = j;
                     break;
                 }
             }
         }
         for (int i = 0;i<4;i++){
            if (maze[0][i]==0){
                ArrayList<Point> path = new ArrayList<>();
                path.add(new Point(0,i));
                boolean [][] vis = new boolean[4][4];
                vis[0][i] = true;
                dfs(0,i,path,vis);
            }
         }

        for (int i = 0;i<4;i++){
            if (maze[i][0]==0){
                ArrayList<Point> path = new ArrayList<>();
                path.add(new Point(i,0));
                boolean [][] vis = new boolean[4][4];
                vis[i][0] = true;
                dfs(i,0,path,vis);
            }
        }
        for (int i = 0;i<4;i++){
            if (maze[i][3]==0){
                ArrayList<Point> path = new ArrayList<>();
                path.add(new Point(i,3));
                boolean [][] vis = new boolean[4][4];
                vis[i][3] = true;
                dfs(i,3,path,vis);
            }
        }
        for (int i = 0;i<4;i++){
            if (maze[3][i]==0){
                ArrayList<Point> path = new ArrayList<>();
                path.add(new Point(3,i));
                boolean [][] vis = new boolean[4][4];
                vis[3][i] = true;
                dfs(3,i,path,vis);
            }
        }
        return res;
    }

    public static int [][] flag = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private static void dfs(int x, int y, ArrayList<Point> path, boolean[][] vis) {
        for (int i = 0;i<4;i++){
            int newX = x+flag[i][0];
            int newY = y+flag[i][1];
            if (newX==tarx&&newY==tary) {
                if (path.size()<min){
                    min = path.size();
                    ArrayList<Point> points = new ArrayList<>(path);
                    points.add(new Point(tarx,tary));
                    res = points;
                    return;
                }
            }
            if (newX >=0 && newX <4 && newY>=0&&newY<4&&maze[newX][newY] == 0&& !vis[newX][newY]){
                path.add(new Point(newX,newY));
                vis[newX][newY] = true;
                dfs(newX,newY,path,vis);
                path.remove(path.size()-1);
            }
        }
        return ;
    }
}
