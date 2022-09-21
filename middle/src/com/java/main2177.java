package com.java;

/**
 * @author: zms
 * @create: 2022/9/21 10:49
 */
public class main2177 {
    public long[] sumOfThree(long num) {
        if (num % 3 == 0) {
            return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
        }
        return new long[]{};
    }
}
