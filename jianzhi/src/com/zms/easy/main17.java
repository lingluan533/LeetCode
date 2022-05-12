package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/3/2 14:46
 */
public class main17 {
    public int[] printNumbers(int n) {
        int max =(int) Math.pow(10,n) - 1;
        int res[] = new int[max];
        for(int i = 0;i<max;i++){
            res[i] = i+1;
        }
        return res;
    }
}
