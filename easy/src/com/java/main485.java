package com.java;

/**
 * @author: zms
 * @create: 2022/8/16 20:02
 */
public class main485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0;i<len;i++){
            if (nums[i]==1){
                cur++;
            }else{
                max = Integer.max(cur,max);
                cur = 0;
            }
        }
        max = Integer.max(cur,max);
        return max;
    }
}
