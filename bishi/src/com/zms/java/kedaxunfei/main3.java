package com.zms.java.kedaxunfei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/8/20 20:30
 */
public class main3 {
    public ArrayList<Point> rev(ArrayList<Point> r){
        Stack<Point> stack = new Stack<>();
        for (int i =0;i<r.size();i++){
            stack.add(r.get(i));
        }
        ArrayList<Point> rr = new ArrayList<>();
        while (!stack.isEmpty()){
            rr.add(stack.pop());
        }
        return rr;
    }
    public class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
    public ArrayList<Point> winMazeGift (int[][] maze) {
      boolean [][]vis = new boolean[4][4];
      ArrayList<Point> ans = new ArrayList<>();
      for (int i= 0;i<4;i++){
          for (int j = 0;j<4;j++){
              if(maze[i][j] == 8){
                  vis[i][j] = true;
                  ans.add(new Point(i,j));
              }
          }
      }

        Queue<ArrayList<Point>> re = new LinkedList<>();
      re.offer(ans);
      int dir[][] = {{0,-1},{0,1},{-1,0},{1,0}};
      while (!re.isEmpty()){
          int size = re.size();
          for (int j = 0;j<size;j++){
              ArrayList<Point> top = re.poll();
              Point las = top.get(top.size()-1);
              vis[las.x][las.y] = true;
              for (int i  =0;i<4;i++){
                  int xx = las.x + dir[i][0];
                  int yy = las.y +dir[i][1];
                  if(xx>=0 && yy>=0 && xx<4&&yy<4&&maze[xx][yy]==0&&!vis[xx][yy]){
                      ArrayList<Point> per = new ArrayList<>(top);
                      per.add(new Point(xx,yy));
                      if (xx==0||yy==0||xx==3||yy==3){
                          return rev(per);
                      }
                      re.add(per);
                  }
              }
          }
      }
      return rev(ans);
    }

}


