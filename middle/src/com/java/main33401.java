package com.java;

/**
 * @author: zms
 * @create: 2022/1/12 22:53
 */
public class main33401 {
    public boolean increasingTriplet(int[] nums) {
       int min = Integer.MAX_VALUE,middle = min;
       int len = nums.length;
       if(len<3) return false;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] < min){
                min = nums[i];
            }else if(nums[i] < middle){
                middle = nums[i];
            }else{
                return true;
            }
        }


        return false;
    }
}
