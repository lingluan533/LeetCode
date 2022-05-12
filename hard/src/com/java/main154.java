package com.java;

/**
 * @author: zms
 * @create: 2022/3/18 19:27
 */
public class main154 {
    public int findMin(int[] nums) {
            int n = nums.length;
            if(n==1) return nums[0];
            int left = 0;
            int right = n - 1;
            while(left < right){
                int mid = left + (right - left) /2 ;
                if(nums[mid] > nums[right]){
                    left = mid + 1;
                }else if(nums[mid] < nums[right]){
                    right = mid ;
                }else{
                    right -- ;
                }
            }
            return nums[left];
    }
}
