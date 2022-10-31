package com.java;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/10/17 14:51
 */
public class main99401 {
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] flag = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int countFresh = 0;
        int curTime = 0;
        Queue<int[]> queue = new ArrayDeque();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    countFresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            boolean flag1 = false;
            while (curSize > 0) {
                curSize--;
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int k = 0; k < 4; k++) {
                    int newX = x + flag[k][0];
                    int newY = y + flag[k][1];
                    if (!(newX >= 0 && newX < m && newY >= 0 && newY < n)) {
                        continue;
                    }// 边界判定
                    if (grid[newX][newY] == 1) {
                        flag1 = true;
                        countFresh--;
                        grid[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            if (flag1)
                curTime++;
        }
        return countFresh == 0 ? curTime : -1;
    }
}
