package com.java;

/**
 * @author: zms
 * @create: 2022/4/27 11:25
 */
public class main12203 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int sum = 0;
        for(int i = 1 ;i<len;i++){
            int cha = prices[i] - prices[i-1];
            if(cha > 0) sum += cha;
        }
    return sum;
    }

}
