package com.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: zms
 * @create: 2022/9/6 10:14
 */
public class main23901 {
    public static void main(String[] args) {
        String a = new String();
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int n = nums.length, m = n - k + 1;
        int[] ans = new int[m];
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && nums[d.peekLast()] <= nums[i]) d.pollLast();
            d.addLast(i);
            if (i >= k - 1) {
                while (!d.isEmpty() && d.peekFirst() <= i - k) d.pollFirst();
                ans[i - k + 1] = nums[d.peekFirst()];
            }
        }
        return ans;
    }
}
