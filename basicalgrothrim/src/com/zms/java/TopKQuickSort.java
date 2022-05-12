package com.zms.java;

/**
 * @author: zms
 * @create: 2022/3/17 17:18
 */
public class TopKQuickSort {

    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,3,1,2,4,5,5,6 },4);
    }
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int target = n - k;
        while(left <right){
            int index = partition(left,right,nums);
            if(index == target) return nums[index];
             if(index > target){
                 //上次分区得到的最终位置是比k大的一个数
                 right = index - 1 ;
             }else{
                //上次分区得到的最终位置是比k小的一个数
                 left = index + 1;
             }
        }
        return nums[left];

    }

    private static int partition(int left, int right, int[] nums) {
        int priovit = nums[left];
        int i = left;
        int j = right;
        if(i < j){
            while(i < j){
                while(i < j && nums[j] >= priovit){
                    j--;
                }
                if(i < j){
                    nums[i] = nums[j];
                }

                while(i  < j && nums[i] < priovit){
                    i++;
                }
                if(i < j){
                    nums[j] = nums[i];
                }
            }
        }

        nums[i] = priovit;
        return i;


    }

}
