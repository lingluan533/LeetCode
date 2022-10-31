package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/10/29 20:37
 */
public class main135 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }

    public static int candy(int[] ratings) {
        int len = ratings.length;
        int left[] = new int[len];
        int right[] = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (Integer i : left) {
            System.out.print(i + " ");

        }
        System.out.println();
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            left[i] = Math.max(left[i], right[i]);
            sum += left[i];
        }
        return sum;
    }
}
