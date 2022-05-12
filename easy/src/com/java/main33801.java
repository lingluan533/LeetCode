package com.java;

/**
 * @author: zms
 * @create: 2022/1/9 0:17
 */
public class main33801 {
    public int[] countBits(int n) {
        int dp[] = new int [n+1];
        for (int i = 1;i<=n;i++){
            if(i % 2 == 0){
                dp[i] = dp[i/2] +1 ;

            }else{
                dp[i] = dp[(i-1)/2] ;
            }
        }
        return dp;

    }
}
