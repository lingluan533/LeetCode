package com.java;

/**
 * @author: zms
 * @create: 2021/12/25 10:08
 */
public class main2110 {

    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        if (n==1) {
            return 1;
        }
        int ans = 0;
        for (int i =1;i<n;i++){
            if(prices[i] +1 == prices[i-1]){
                ans ++;
            }else{
                
            }
        }
        return n;
    }

    public static void main(String[] args) {

    }
}
