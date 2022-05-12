package com.java;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/3/15 15:06
 */


public class main210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> [] adj = new HashSet[numCourses];
        int indegree[] = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int  res [] = new int[numCourses]; //用来记录合法序列
        // prerequisites[i] = [1,0] 表示 学习1之前要先学习0 即0-->1 即0是1的先驱节点  1的入度要加1
        for(int i = 0;i<numCourses;i++){
            adj[i] = new HashSet<>();
        }
        for(int i = 0;i<prerequisites.length;i++){

            adj[prerequisites[i][1]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]] ++;//该点的入度加一
        }

        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);       //入度为0 的先入队
            }
        }

        //初始化结束----------------------
        int count = 0;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            res[count++] = poll;
            for(Integer nextCourse : adj[poll]){
               indegree[nextCourse]--;
               if(indegree[nextCourse]==0){
                   queue.add(nextCourse);
               }
            }

        }

//        if(queue.isEmpty()){  //用queue判断最终是否有合法序列是有问题的，应该看count是否等于numCourse  因为如果从来过入度为0的点，程序直接到这里 也会使得队列为空 ，从而导致错误答案
//            return res;
//        }
        if(count == numCourses) return res;
        return new int[0];



    }
}
