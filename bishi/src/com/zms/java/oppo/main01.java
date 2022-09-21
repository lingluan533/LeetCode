package com.zms.java.oppo;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/9/2 15:17
 */
public class main01 {

    public int maxDigit (int[] digits) {
        Arrays.sort(digits);
    int t = 1;
    int res = 0;
        for (int i = 0;i<digits.length;i++){
            res += digits[i] * t;
            t*=10;
        }

        return res;
    }
}
