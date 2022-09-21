package com.java;

/**
 * @author: zms
 * @create: 2022/9/4 10:11
 */
public class main19101 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
