package com;

/**
 * @author: zms
 * @create: 2022/4/25 11:41
 */
public class main12202 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int stock[][] = new int[2][len];
        stock[0][0] = -1*prices[0];
        stock[1][0] = 0;
        for(int i = 1;i<len;i++){
            stock[0][i] = Math.max(stock[0][i-1], stock[1][i-1]-1*prices[i]);
            stock[1][i] = Math.max(stock[1][i-1],prices[i] + stock[0][i-1]);

        }
        return stock[1][len];
    }
}
