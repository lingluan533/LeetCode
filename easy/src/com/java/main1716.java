package com.java;

/**
 * @author: zms
 * @create: 2022/1/15 23:40
 */
public class main1716 {
    public int totalMoney(int n) {
        int weeks = n/7;
        int res = weeks * 28 + weeks*(weeks-1)/2*7;
        int days = n %7;
        int t = 0;
        for(int i = 1;i<=days;i++){
          t += weeks+i;
        }
        return res+t;
    }
}
