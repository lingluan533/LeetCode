package com.java;

/**
 * @author: zms
 * @create: 2022/4/5 15:46
 */
public class main503 {
    public int[] nextGreaterElements(int[] nums) {
        int res [] = new int[nums.length];
        int len = nums.length;
        for(int i = 0;i< nums.length;i++){
            boolean flag = false;
            for(int j = i + 1 ;j<len;j++){
                if(nums[j] > nums[i]){
                    res[i] = nums[j];
                    flag = true;
                    break;
                }
            }
            if(!flag)
            for(int j = 0;j<i;j++){
                if(nums[j] > nums[i]){
                    res[i] = nums[j];
                    flag = true;
                    break;
                }
            }
            if(!flag) res[i] = -1;
        }


        return res;
    }
}
