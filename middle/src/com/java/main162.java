package com.java;

/**
 * @author: zms
 * @create: 2022/3/6 23:00
 */
public class main162 {
    public int findPeakElement(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while(left < right){
                int mid = left + (right - left ) /2;
                if(nums[mid] > nums[mid-1]){
                   left = mid;
                }else right = mid -1;
            }
            return left;
    }
}
