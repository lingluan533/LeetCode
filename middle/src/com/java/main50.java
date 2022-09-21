package com.java;

/**
 * @author: zms
 * @create: 2022/9/9 11:18
 */
public class main50 {
    public double myPow(double x, int n) {
        boolean flag = true;
        if (n < 0) {
            n *= -1;
            flag = false;
        }
        double t = x;
        double res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                t *= x;
            }
            res *= t;
            n = n >> 1;
        }
        return res;

    }
}
