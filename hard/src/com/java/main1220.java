package com.java;

/**
 * @author: zms
 * @create: 2022/1/17 13:12
 */
public class main1220 {
    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long dp[][] = new long[n+1][5];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        for(int i=2;i<=n;i++){
            dp[i][0] = (dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%mod;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%mod;
            dp[i][2] = (dp[i-1][1]+dp[i-1][3])%mod;
            dp[i][3] = (dp[i-1][2])%mod;
            dp[i][4] = (dp[i-1][2]+dp[i-1][3])%mod;

        }
        long sum = 0;
      //  sum = Math.floorMod(dp[n][0],10^9 + 7)  + Math.floorMod(dp[n][1],10^9 + 7)    + Math.floorMod(dp[n][2],10^9 + 7)  + Math.floorMod(dp[n][3],10^9 + 7)  +Math.floorMod(dp[n][4],10^9 + 7) ;
        sum = (dp[n][0] + dp[n][1] +dp[n][2]+dp[n][3]+dp[n][4])%mod;


        return (int)sum;
    }
}
