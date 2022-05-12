package com;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/3/24 16:44
 */
public class main3101 {

    public static void main(String[] args) {
        nextPermutation(new int[]{1,2,3,4,6,5});
    }
        public static void nextPermutation(int[] nums) {
            int len = nums.length;
            boolean  flag = false;
            for(int i=len-1;i>=1;i--){
                if(nums[i]>nums[i-1]){
                    flag = true;
                    reverse(nums,i,len-1);
                    for(int j = i;j<=len-1;j++){
                        if(nums[j]>nums[i-1]){
                            int tem = nums[i-1];
                            nums[i-1] = nums[j];
                            nums[j] = tem;
                            break;
                        }

                    }


                    break;
                }
            }
            if(!flag)
                Arrays.sort(nums);

        }
        /**
         * @param nums  数组
         * @param i  起始点
         * @param j  终点
         */
        private static void reverse(int[] nums, int i, int j) {

            if(i==j) return;
            for(int l=i;l<j;l++){
                for(int k=i;k<j;k++){
                    if(nums[k]>nums[k+1]){
                        int tem = nums[k];
                        nums[k] = nums[k+1];
                        nums[k+1] = tem;
                    }
                }
            }

        }

    }


