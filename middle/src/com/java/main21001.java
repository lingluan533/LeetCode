package com.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @author: zms
 * @create: 2022/10/29 20:57
 */
public class main21001 {
    public static void main(String[] args) {
        findOrder(2, new int[][]{{1, 0}});
        //findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] edge = new HashSet[numCourses];
        int indegree[] = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque();
        for (int i = 0; i < numCourses; i++) {
            edge[i] = new HashSet<>();
        }
        int res[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            edge[prerequisites[i][1]].add(prerequisites[i][0]);// edge 记载的某个点的后继边
            indegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll(); // 入度为0的点
            res[count++] = poll;
            for (Integer next : edge[poll]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}
