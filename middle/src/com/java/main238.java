package com.java;

/**
 * @author: zms
 * @create: 2022/1/12 22:16
 */
public class main238 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        productExceptSelf(ints);
    }
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int res [] = new int [len];
        int left [] = new int[len];
        int right [] = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        for(int i=1;i<len;i++){
            left[i] = left[i-1] * nums[i-1];
        }
        for(int j=len-2;j>=0;j--){
            right[j] = right[j+1] * nums[j+1];
        }

        for(int i=0;i<len;i++){
            System.out.print(left[i]+" ");
        }
        System.out.println();
        for(int j=0;j<=len-1;j++){
            System.out.print(right[j]+" ");
        }

        for(int i=0;i<len;i++){
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
