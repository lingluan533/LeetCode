package com.java;

/**
 * @author: zms
 * @create: 2022/8/7 20:09
 */
public class main70401 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left)/2 ;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target){
                right = mid;
            }else left = mid + 1;
        }
        return nums[left] == target ? left : -1;
    }
}
