package com.java.double71;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author: zms
 * @create: 2022/2/5 22:17
 */
public class main {
    public int minimumSum(int num) {
        int a[] = new int[4];
        a[0] = num /1000;
        a[1] = (num %1000)/100;
        a[2] = ((num %1000)%100)/10;
        a[3] = (num%1000%100%10);
        Arrays.sort(a);

        return a[0]*10+a[2] + (a[1]*10 + a[3]);
    }
}
