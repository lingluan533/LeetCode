package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/4/23 11:14
 */
public class main396 {
    public static void main(String[] args) {
        int a [] = new int[]{4,3,2,6};
            maxRotateFunction(a);
    }
    public static int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        //生成翻转后的数组
        for(int i = 0,j=len-1;i<=(len-1)/2;i++,j--){
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }
        //4 3 2 6
        for(int i = 0 ; i < len ;i++){  //右移i位
            //生成本次的字符串
            int tem [] = Arrays.copyOf(nums,len);
            int cur [] = rightArray(tem,i);
            for( int k = 0;k<len;k++){
                System.out.print(cur[k]+" ");
            }
            int curSum = 0;
            for(int j = 0 ;j < len; j++){
                curSum += j * cur[j];
            }
            max = Integer.max(curSum,max);
        }
        return max;
    }

    private static int[] rightArray(int[] nums, int k) { // 循环右移k位 返回新的数组 前k个翻转 后 n-k个翻转
        int len = nums.length;
        if(k!=0)
        for (int i = 0,j = k-1 ; i<=(k-1)/2 ; i++,j--){ //前k个
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }
        if(k!=len)
        for (int i = k,j = len - 1 ; i <= k + (len - 1 - k) / 2  ; i++,j--){ //后n-k个
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }
        return  nums;
    }
}
