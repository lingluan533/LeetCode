package com.zms.java.didi;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/4 19:37
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int aryl[] = new int[T];
        for (int i = 0; i < T; i++) {
            aryl[i] = scan.nextInt();
        }
        int aryr[] = new int[T];
        for (int i = 0; i < T; i++) {
            aryr[i] = scan.nextInt();
        }
        int aryt[] = new int[T];
        for (int i = 0; i < T; i++) {
            aryt[i] = scan.nextInt();
        }

        for (int i = 0; i < T; i++) {
            long count = 0;
            int left = aryl[i];
            int right = aryr[i];
            for (int j = left; j <= right; j++) {
                int val = 0;
                String a = j + "";
                for (int k = 0; k < a.length(); k++) {
                    val ^= a.charAt(k) - '0';
                }
                if (val == aryt[i]) count++;
            }
            if (i == T - 1)
                System.out.print(count);
            else System.out.println(count + " ");
        }


    }
}

