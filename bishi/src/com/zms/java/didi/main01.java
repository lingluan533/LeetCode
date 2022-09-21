package com.zms.java.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/4 19:20
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        long ary[] = new long[n];
        for (int i = 0; i < n; i++) {
            ary[i] = scan.nextLong();
        }
        int mod = 1000000000;
        Arrays.sort(ary);
        long sum = 0, count = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            long cur = ary[i];
            sum = (sum + ary[i]) % mod;
            count++;
            max = Math.max(max, cur) % mod;
            if (max > (sum / count) * k) {
                System.out.println(count - 1);
                return;
            }
        }
        System.out.println(count);
    }
}
