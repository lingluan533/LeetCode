package com.java;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/9/6 9:44
 */
public class main239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int res[] = new int[len - k + 1];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            queue.add(new int[]{i, nums[i]});
            if (i >= k - 1) {
                while (queue.peek()[0] < i - k) queue.poll();
                res[ans++] = queue.peek()[1];
            }
        }
        return res;
    }
}
