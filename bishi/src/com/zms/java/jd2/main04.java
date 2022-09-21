package com.zms.java.jd2;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/3 18:54
 */
public class main04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ary[] = new int[n];
        int max = 0;
        boolean isPa[];

        for (int i = 0; i < n; i++) {
            ary[i] = scan.nextInt();
            max = Math.max(max, ary[i]);
        }
        int dp[] = new int[max + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;

        isPa = new boolean[max + 5];  //默认全是素数
        isPa[2] = true;
        isPa[3] = true;
        for (int i = 2; i < max; i++) {
            if (isPa[i])
                for (int j = 1; j * i <= max; j++) {
                    isPa[i * j] = true;
                }
        }
        isPa[2] = false;
        isPa[3] = false;
        for (int i = 3; i <= max; i++) {
            if (!isPa[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        dp[i] = dp[i / j] + dp[j] + 1;
                        break;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += dp[ary[i]];
        }
        System.out.println(res);
    }
}
