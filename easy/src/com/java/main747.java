package com.java;

/**
 * @author: zms
 * @create: 2022/1/13 22:37
 */
public class main747 {
    public int dominantIndex(int[] nums) {
        if(nums.length==1) return 0;
        if(nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        int max,maxindex,second,secondindex;
        if(nums[0] > nums[1]){
            max = nums[0];
            maxindex = 0;
            second = nums[1];
            secondindex = 1;
        }else{
            max = nums[1];
            maxindex = 1;
            second = nums[0];
            secondindex = 0;
        }
        for (int i =2;i< nums.length;i++){
            if(nums[i] > max){
                second = max;
                secondindex = maxindex;
                max = nums[i];
                maxindex = i;
            }else if(nums[i] > second){
                second = nums[i];
                secondindex = i;
            }
        }
        if(max > 2*second){
            return maxindex;
        }

        return -1;
    }
}
