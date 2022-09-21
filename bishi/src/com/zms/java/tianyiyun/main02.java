package com.zms.java.tianyiyun;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/14 22:08
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int diff[] = new int[1000000]; //差分数组
        int a[] = new int[1000000]; //原数组
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            diff[x]++;
            diff[y]--;
        }
        for (int i = 1; i < 1000000; i++) {
            a[i] = diff[i] + a[i - 1];
        }
        int count = 0;
        for (int i = 1; i < 1000000; i++) {
            if (a[i] == 1) {
                count++;
            }
        }
        System.out.println(count);

    }
}
