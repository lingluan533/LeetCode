package com.zms.java.ali;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/5 22:40
 */
public class main03 {
    public static void main(String[] args) {
        my();
    }
    private static void my() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            int sum = 0, step = 1;
            while (x > 0) {
                sum += (x % 10) * step;
                step *= 10;
                step += 1;
                x /= 10;
            }
            sum += y;
            System.out.println(splitNum(sum));
        }
    }

    private static int splitNum(int x) {
        int i = 0, step = 1;
        while (step < x) {
            step *= 10;
            step += 1;
            i++;
        }
        if (step == x) {
            return (int) Math.pow(10, i);
        }
        step /= 10;
        i--;

        int sum = 0;
        while (i >= 0) {
            int j = 1;
            for (j = 1; j <= 9; j++) {
                if (j * step > x) break;
            }
            if (j * step > x) j--;
            sum += Math.pow(10, i) * j;
            x -= step * j;
            step /= 10;
            i--;
        }
        return sum;

    }}
