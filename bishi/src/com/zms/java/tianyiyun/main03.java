package com.zms.java.tianyiyun;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/14 20:33
 */
public class main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int j = scan.nextInt();
        int jiaju[] = new int[j];
        for (int i = 0; i < j; i++) {
            jiaju[i] = scan.nextInt();
        }
        int j1 = scan.nextInt();
        int haoli[] = new int[j1];
        for (int i = 0; i < j1; i++) {
            haoli[i] = scan.nextInt();
        }
        System.out.println(maxSumValue(M, jiaju, haoli));
    }

    private static int maxSumValue(int m, int[] v, int[] w) {
        int n = w.length;
        int dp[][] = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {  // 物品序号
            for (int j = 1; j < m + 1; j++) { //背包重量
                if (j < w[i - 1])
                    // 不放物品i：由dp[i - 1][j]推出，即背包容量为j，里面不放物品i的最大价值，此时dp[i][j]就是dp[i - 1][j]。(其实就是当物品i的重量大于背包j的重量时，物品i无法放进背包中，所以被背包内的价值依然和前面相同。)
                    dp[i][j] = dp[i - 1][j];
                else
                    //放物品i：由dp[i - 1][j - weight[i]]推出，dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，那么dp[i - 1][j - weight[i]] + value[i] （物品i的价值），就是背包放物品i得到的最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
            }
        }
        return dp[n][m];
    }
}


