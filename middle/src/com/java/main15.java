package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2021/12/31 10:16
 */
public class main15 {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> temp ;
        int a =0,b=0,c=0;
        for(int k=0;k<len;k++){  //枚举最小的数nums[k]  另两个数都大于该数 直到nums[k]>0 则可以退出程序了
            if(k>0 && nums[k] == nums[k-1]){        //去重
                continue;
            }
            int i = k+1;
            int j = len-1;

            while(i<j){
                if(nums[k] + nums[i] >0) break;
                else if(nums[k] + nums[i] + nums[j] == 0){
                    temp = new ArrayList<>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);

                    while(i<j &&nums[i]== nums[++i]);
                    while(i<j && nums[j] == nums[--j]);
                }else if(nums[k] + nums[i] + nums[j] <0){  //小于0 说明总体太小 应该移动左指针
                    while(i<j && nums[i] == nums[++i]  && nums[k] + nums[i] + nums[j] <0);

                }else  while(i<j && nums[j] == nums[--j]  && nums[k] + nums[i] + nums[j] >0);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
