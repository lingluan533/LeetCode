package com.java;

/**
 * @author: zms
 * @create: 2022/9/4 9:59
 */
public class main191 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) count++;
        }

        return count;
    }
}
