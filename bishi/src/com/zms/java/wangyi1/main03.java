package com.zms.java.wangyi1;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/4 15:21
 */
public class main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ary[] = new int[n];
        int bry[] = new int[n];
        int ca[] = new int[n - 1];
        int cb[] = new int[n - 1];
        boolean b[] = new boolean[n - 1];
        for (int i = 0; i < n; i++) {
            ary[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bry[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            ca[i] = ary[i + 1] - ary[i];
            cb[i] = bry[i + 1] - bry[i];
            if (ca[i] == cb[i]) b[i] = true;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (b[i]) {
                int start = i;
                while (++start < n - 1 && b[start]) ;
                max = Math.max(max, start - i);
                i = start - 1;
            }
        }
        System.out.println(max == Integer.MIN_VALUE ? 0 : max + 1);


    }
}
