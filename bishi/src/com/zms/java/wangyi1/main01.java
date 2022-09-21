package com.zms.java.wangyi1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/4 15:00
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ary[] = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = scanner.nextInt();
        }
        Arrays.sort(ary);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, ary[i + 1] - ary[i]);
        }
        System.out.println(min);
    }
}
