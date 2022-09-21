package com.java;

/**
 * @author: zms
 * @create: 2022/8/16 21:45
 */
public class main1004 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
    public static int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int right = 0,left = 0;
        int zeros = 0;
        int res = 0;
        while (right<len){//右端点主动右移
            if (nums[right]==0) //如果是0 则区间内0的个数+1
                zeros++;
            while (zeros>k){    // 当区间内0的个数超标时，左端点被迫右移
                if (nums[left++]==0)    // 直到左端点的移动使得区间内0的个数减少
                    zeros--;
            }
            res = Math.max(res,right-left+1);// 此时到达一个合理的状态，检查是否呀要更新
            right++;                        // 右端点右移
        }
        return res;
    }
}
