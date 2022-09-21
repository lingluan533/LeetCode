package com.java;

/**
 * @author: zms
 * @create: 2022/8/9 21:21
 */
public class main1413 {
    public int minStartValue(int[] nums) {
        int cur = 1;

        for(int i=1;i< nums.length;i++){
            nums[i] = nums[i-1] + nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]+cur<1){
                cur++;
                i=-1;
            }
        }
        return cur;
    }
}
