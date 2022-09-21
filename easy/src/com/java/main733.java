package com.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/8/15 22:55
 */
public class main733 {
    class Index{
        int x;
        int y;
        public Index(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean vis[][] = new boolean[m][n];
        int res  [][] = new int[m][n];
        for (int i = 0;i<m;i++){
            res[i] = Arrays.copyOf(image[i],image[i].length);
        }


        int start = image[sr][sc];
        ArrayDeque<Index> deque = new ArrayDeque();
        deque.add(new Index(sr,sc));
        while (!deque.isEmpty()){
            int curSize = deque.size();
            while(curSize>0){
                Index poll = deque.poll();
                if(vis[poll.x][poll.y]){
                    continue;
                }
                vis[poll.x][poll.y]  = true;
                res[poll.x][poll.y] = color;
                int x = poll.x;
                int y = poll.y;
                if(x-1 >=0&& !vis[x - 1][y] && image[x-1][y]==start) deque.add(new Index(x-1,y));
                if(x+1 <m && !vis[x + 1][y] && image[x+1][y]==start) deque.add(new Index(x+1,y));
                if(y-1 >=0&& !vis[x ][y-1] && image[x][y-1]==start) deque.add(new Index(x,y-1));
                if(y+1 <n&& !vis[x ][y+1] && image[x][y+1]==start) deque.add(new Index(x,y+1));
        }
    }
        return res;
}}
