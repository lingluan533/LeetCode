package com.zms.java.huawei01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/21 18:57
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int records[] = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            records[i] = scan.nextInt();
        }
        total = scan.nextLong();
        Arrays.sort(records);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += records[i];
        }
        if (sum < total) {
            System.out.println(-1);
            return;
        }
        long cur = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            cur = records[i] + cur;
            if ((long) (n - i - 1) * records[i] + cur < total) {
                max = records[i];
                continue;
            } else {
                if ((n - i - 1) * records[i] + cur == total) {
                    max = records[i];
                    System.out.println(max);
                    return;
                } else {
                    int t = records[i];
                    while ((long) (n - i - 1) * t + cur > total) {
                        t--;
                    }
                    System.out.println(t);
                    return;
                }
            }

        }
    }
}
