package com.java;

/**
 * @author: zms
 * @create: 2022/1/8 23:57
 */
public class main338 {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for(int i =0;i<=n;i++){
            res[i] = getErjinzhiCount1(i);
        }
        return res;
    }

    private int getErjinzhiCount1(int i) {
        int count = 0;
        while( i  !=0){
               count += i%2==0? 0:1;
               i /=2;
        }
        return count;
    }
}
