package com.java;

/**
 * @author: zms
 * @create: 2022/10/16 18:07
 */
public class main4502 {
    public int jump(int[] nums) {
        int start = 0;
        int end = 1;
        int maxPos = 0;
        int count = 0;
        while (end < nums.length - 1) {
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos;
            count++;
        }
        return count;
    }
}
