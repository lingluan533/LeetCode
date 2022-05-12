package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * 字节面试题，求大佬们看看，数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n的最大数。
 * 例如A={1, 2, 4, 9}，x=2533，返回2499
 * @create: 2022/4/20 10:06
 */
public class ByteDance {
    public static void main(String[] args) {
        int num = 2000;
        int numns [] = new int[]{1,2,4,9};
        System.out.println(getMax(num, numns));
    }
    public static int max = Integer.MIN_VALUE;
    public static int len ;
    public static int targetNum;
    public static int [] nums;
    public static int getMax(int target, int [] array){
        Arrays.sort(array);
        int length = (target + "").length();
        targetNum = target;
        len = length;
        nums = array;
        dfs(0,0);
        return max;
    }

    private static void dfs(int cur, int curLen) {
        max = Math.max(max,cur);
        if(curLen == len) return;
        for(int i = 0; i < nums.length;i++){
            int tem  = cur *10 + nums[i];
            if(tem >= targetNum){
                continue;
            }
            cur = cur * 10 + nums[i];
            curLen+=1;
            dfs(cur,curLen);
            cur /= 10;
            curLen -= 1;

        }
    }
}
