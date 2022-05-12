package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/1/22 13:15
 */
public class main18901 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }
    public static int[] rotate(int[] nums, int k) {
        int tem [] = new int[nums.length];

        for(int i = 0;i< nums.length;i++){
            tem[(i+k)% nums.length] = nums[i];
        }
        nums = Arrays.copyOf(tem,tem.length);
      //  System.arraycopy(tem, 0, nums, 0, tem.length);
        return nums;
    }
}
