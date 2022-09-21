package com.zms.java;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/9/16 10:56
 */
public class main01 {
    public static void main(String[] args) {

    }

    public int minPath(int[] w1, int[] w2, int N) {
        int x1 = w1[0];
        int y1 = w1[1];
        int x2 = w2[0];
        int y2 = w2[1];
        int pathCount = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x1, y1});
        HashSet<String> pathSet = new HashSet<>();//
        pathSet.add(x1 + y1 + "");
        int flag[][] = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        while (!q.isEmpty()) {
            int curSize = q.size();
            pathCount++;
            while (curSize > 0) {
                int[] poll = q.poll();
                curSize--;
                int x = poll[0];
                int y = poll[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + flag[i][0];
                    int newY = y + flag[i][1];
                    if (!(newX >= 0 && newX < N && newY >= 0 && newY < N)) {
                        continue;
                    }//坐标检验
                    if (pathSet.contains(newX + newY + "")) {
                        continue;
                    }
                    if (newX == x2 && newY == y2) {
                        return pathCount; //结果得到
                    }
                    pathSet.add(newX + newY + "");
                    q.add(new int[]{newX, newY});
                }
            }
        }
        return -1; //走不到

    }
}
