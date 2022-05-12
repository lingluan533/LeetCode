package com.java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/1/11 23:21
 */
public class main207 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[1][2];
        prerequisites[0] = new int[]{1,0};
        canFinish(2,prerequisites);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
      boolean adj[][] = new boolean [numCourses][numCourses];
      int rudu[] = new int [numCourses];

      for(int i =0;i< prerequisites.length;i++){
        adj[prerequisites[i][0]][prerequisites[i][1]] = true;
        rudu[prerequisites[i][1]] ++;
      }

        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        for(int i =0;i<numCourses;i++){
            if(rudu[i] ==0) pq.add(i);
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            cnt++;
            for(int i=0;i<numCourses;i++){
                if(adj[cur][i] == true){
                    rudu[i] --;
                    if(rudu[i] ==0) pq.add(i);
                }

            }
        }
        return cnt == numCourses;
    }
}
