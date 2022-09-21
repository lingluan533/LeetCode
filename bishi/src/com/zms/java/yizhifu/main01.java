package com.zms.java.yizhifu;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/11 17:40
 */
public class main01 {
    public static void main(String[] args) {
        double as = Math.pow(10, 999999999);
        System.out.println(as);
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int h = scan.nextInt();
        int b = scan.nextInt();
        int k = scan.nextInt();
        long damage = 0;

        while (h > 0 && k > 0) {
            damage += b;
            damage += a;
            h -= b;
            k -= a;
            if (h <= 0 && k <= 0) {
                System.out.println(damage);
                return;
            } else if (h <= 0) {
                damage += b * 10;
                System.out.println(damage);
                return;
            } else if (k <= 0) {
                damage += a * 10;
                System.out.println(damage);
                return;
            }
        }

    }
}
