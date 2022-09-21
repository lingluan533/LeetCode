package com.java;

/**
 * @author: zms
 * @create: 2022/9/11 12:11
 */
public class main674 {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            while (j + 1 < len && nums[j + 1] > nums[j]) {
                j++;
            }
            max = Math.max(j - i + 1, max);
            i = j;
        }
        return max;
    }
}
