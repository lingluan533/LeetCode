package com.java;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zms
 * @create: 2022/10/16 17:45
 */
public class main4501 {
    public int jump(int[] nums) {
        Deque<Integer> qeque = new ArrayDeque<>();
        qeque.add(0);
        int count = 0;
        while (!qeque.isEmpty()) {
            int curSize = qeque.size();
            count++;
            while (curSize > 0) {
                curSize--;
                Integer poll = qeque.poll();
                int step = nums[poll];
                for (int i = poll + 1; i <= poll + step; i++) { // 下标
                    if (i == nums.length - 1) {
                        return count;
                    }
                    if (!qeque.contains(i)) {
                        qeque.add(i);
                    }
                }

            }
        }
        return 0;
    }
}
