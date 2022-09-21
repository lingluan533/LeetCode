package com.zms.java.kedaxunfei;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/8/21 0:14
 */
public class main0302 {
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
    //BFS做法   想象这是一个n叉树，从根节点自里向外层次遍历，当有节点位于边界时便找到了一条最短路径  注意技巧，（在遍历的时候使用Deque<ArrayList> 可以不仅仅找到最终的节点还能在遍历过程中便记录下路径）
    public static ArrayList<Point> winMazeGift (int[][] maze) {
        Deque<ArrayList<Point>> queue = new ArrayDeque<>();
        boolean vis[][] = new boolean[4][4];

        for (int i=0;i<4;i++){
            for (int j = 0;j<4;j++){
                if (maze[i][j] ==8){
                    ArrayList<Point> list = new ArrayList<>();
                    list.add(new Point(i,j));
                    queue.add(list);
                    vis[i][j] = true;
                }
            }
        }
        int flag[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                ArrayList<Point> poll = queue.poll();
                size--;
                Point top = poll.get(poll.size()-1);
                int curx = top.x;
                int cury = top.y;
                for (int i = 0;i<4;i++){
                    int newX = curx + flag[i][0];
                    int newY = cury + flag[i][1];
                    if(newX>=0&&newX<4&&newY>=0&&newY<4&&!vis[newX][newY]&&maze[newX][newY]==0){
                        ArrayList<Point> list = new ArrayList<>(poll);
                        list.add(new Point(newX,newY));
                        queue.add(list);
                        if (newX==0 || newX==3||newY==0||newY==3){
                            return rev(list);
                        }
                    }

                }
            }
        }
        return null;
    }
     static  ArrayList<Point> rev(ArrayList<Point> r){
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
}

