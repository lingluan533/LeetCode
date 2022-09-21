package com.zms.java.yizhifu;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/11 17:55
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long ans = 0, minn = Long.MAX_VALUE;
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            if (n > 6) {
                n -= 6;
                ans = (n / 6) * Math.min(a * 3, b * 2);
                n %= 6;
                n += 6;
            }
            for (int j = 0; j <= 10; j++) {
                for (int k = 0; k <= 10; k++) {
                    if (j * 2 + k * 3 >= n) {
                        minn = Math.min(minn, j * a + k * b);
                    }
                }
            }
            System.out.println(ans + minn);
        }

    }
}
