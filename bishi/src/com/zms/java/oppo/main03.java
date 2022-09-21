package com.zms.java.oppo;

/**
 * @author: zms
 * @create: 2022/9/2 15:11
 */
public class main03 {
    public long tourismRoutePlanning (int scenicspot) {
        int dp [] = new int[scenicspot+1];
        dp[1] = 1 ;
        dp[2] = 2;
        for (int i = 3;i<=scenicspot;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[scenicspot];
    }
}
