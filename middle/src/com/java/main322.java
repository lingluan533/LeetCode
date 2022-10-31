package com.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/10/19 10:17
 */
public class main322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        Queue<Integer> queue = new ArrayDeque<>();
        int step = 1;
        if (amount == 0) {
            return 0;
        }

        queue.add(amount);
        boolean vis[] = new boolean[amount + 1];
        vis[amount] = true;
        Arrays.sort(coins);

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            while (curSize > 0) {
                curSize--;
                Integer poll = queue.poll();
                for (Integer coin : coins) {
                    int next = poll - coin;
                    if (next == 0) return step;
                    if (next < 0) break;
                    if (!vis[next]) {
                        queue.add(next);
                        vis[next] = true;
                    }

                }
            }
            step++;
        }
        // 进入队列的顶点都出队，都没有看到 0 ，就表示凑不出当前面值
        return -1;
    }
}
