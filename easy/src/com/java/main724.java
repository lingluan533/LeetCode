package com.java;

/**
 * @author: zms
 * @create: 2022/8/7 21:26
 */
public class main724 {
    public static void main(String[] args) {

    }
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int left [] = new int[len];
        left[0] = 0;
        int right [] = new int[len];
        right[len-1] = 0;
        for (int i = 1,j=len-2; i<len && j>=0;i++,j--){
                left[i] = left[i-1]+nums[i-1];
                right[j] = right[j+1] + nums[j+1];
        }
        for(int i = 0;i<len;i++){
            if(left[i] == right[i]){
                return i;
            }
        }
        return -1;
    }
}
