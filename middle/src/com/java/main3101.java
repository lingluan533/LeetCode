package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/3/29 14:44
 */
public class main3101 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 1) return;
        for(int i = len-1;i>=0;i--){
            if(i==0){
                Arrays.sort(nums);
                return; //没有可交换的 返回最小序列 满足要求
            }
            if(nums[i] > nums[i-1]){
                //找到可交换的点
                int j = i;
                Arrays.sort(nums,j,len);
                for(j = i; j < len ; j++){
                    if(nums[j] > nums[i-1]){
                        //交换
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        return;
                    }
                }
            }
        }
    }
}
