package com.java;

/**
 * @author: zms
 * @create: 2022/3/20 10:33
 */
public class meituan01 {
    public static void main(String[] args) {
        System.out.println(getMinsortlen(new int[]{1,5,3,4,2,6,7}));
    }
    public static int getMinsortlen(int nums[]){
       int len = nums.length;
       if(len == 1) return 0;
       int start = 0;
       int end = 0;
        for(int i = 1;i<len;i++){
            if(nums[i] >= nums[i-1])continue;
            else {
                start = i-1;
                end = i;
                break;
            }
        }

        for(int i = end + 1;i<len;i++){
            if(nums[i] >= nums[i-1]) continue;
            else {
                end = i;
                continue;
            }
        }
        return end - start + 1;

    }
}
