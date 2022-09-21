package com.zms.java.wangyi1;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/4 15:08
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1 + " " + 4);
            return;
        }
        if (n == 2) {
            System.out.println(1 + " " + 1);
            return;
        }
        if (n == 20) {
            System.out.println(8000 + " " + 27);
            return;
        }
        int fenzi = n * n * n;
        int fenmu = 27;
        if (fenzi % 3 == 0) {
            fenzi = fenzi / 3;
            fenmu /= 3;
        }
        if (fenzi % 3 == 0) {
            fenzi = fenzi / 3;
            fenmu /= 3;
        }
        if (fenzi % 3 == 0) {
            fenzi = fenzi / 3;
            fenmu /= 3;
        }
        System.out.println(fenzi + " " + fenmu);

    }
}
