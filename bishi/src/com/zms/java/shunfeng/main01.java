package com.zms.java.shunfeng;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/31 16:26
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long res = 1;
        for (long i=1;i<n;i++){
            res += i;
        }
        System.out.println(res);
    }
}
