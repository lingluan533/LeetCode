package com.java;

/**
 * @author: zms
 * @create: 2022/10/30 20:14
 */
public class buchong_ring {
    public static void main(String[] args) {
        System.out.println(getStepsToYuandian(2));
    }

    public static int getStepsToYuandian(int n) {
        // 圆环上10个点，编号为0-9 每次可以顺时针或逆时针走一步 问走n步回到0点共有几种走法
        // 等价于 走n-1步到1 + 走 n-1步到9 的总方案
        // 以dp[i][j] 表示从0出发走i步到j的方案总数
        // 则dp[i][j] = dp[i-1][(j-1+10)%10] + dp[i-1][(j+1+10)%10]
        int dp[][] = new int[n + 2][10];
        dp[0][0] = 1;
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + 10) % 10] + dp[i - 1][(j + 1) % 10];
            }
        }
        return dp[n][0];
    }
}
