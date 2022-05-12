package com.java;

/**
 * @author: zms
 * @create: 2022/3/19 21:03
 */
public class main3303 {
    public int search(int[] nums, int target) {
        if(nums[0] == target) return 0;
        int left = 0;
        int right  = nums.length -1 ;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[right]){
                //左边有序
                if(nums[left] <= target && target<nums[mid]){
                    right = mid  ; // 地板除 取不到右边界
                }else{
                    left = mid + 1 ;
                }
            }else{
                //右边有序
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid ;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
