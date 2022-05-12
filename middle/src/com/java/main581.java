package com.java;

/**
 * @author: zms
 * @create: 2022/1/10 0:02
 */
public class main581 {
    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
    }
    public static int findUnsortedSubarray(int[] nums) {
    String a = new String();
        if(nums.length==1) return 0;
        if(nums.length==2) return nums[0] > nums[1] ? 2 : 0;
        boolean flag [] = new boolean[nums.length];
        for(int i =0;i<nums.length;i++){
            for(int j = 0;j<nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    flag[j] = true;
                    flag[j+1] = true;
                    int tem = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tem;
                }
            }
        }
        int f = 0,l = 0;
        for(int i =0;i<nums.length;i++){
            if(flag[i] == true) {f = i;
                break;}
        }
        for(int j = nums.length-1;j>=0;j--){
            if(flag[j] == true){ l = j;
                break;}
        }


    return l-f+1;
    }
}
