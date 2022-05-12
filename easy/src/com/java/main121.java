package com.java;

/**
 * @author: zms
 * @create: 2022/1/4 10:07
 */
public class main121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 1) return 0;
        if(len == 2) return prices[0]<prices[1]?prices[1] - prices[0] : 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++){
            for (int j = i +1 ;j<len;j++){
                max = Math.max(max,prices[j] - prices[i]);
            }
        }
        return max;
    }
}
