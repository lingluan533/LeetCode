package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/9/3 17:04
 */
public class main12002 {
    public static void main(String[] args) {
        ArrayList<List<Integer>> objects = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a3 = new ArrayList<>();
        List<Integer> a4 = new ArrayList<>();
        a1.add(2);
        a2.add(3);
        a2.add(4);
        a3.add(6);
        a3.add(5);
        a3.add(7);
        a4.add(4);
        a4.add(1);
        a4.add(8);
        a4.add(3);
        objects.add(a1);
        objects.add(a2);
        objects.add(a3);
        objects.add(a4);
        minimumTotal(objects);


    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 && i == 1) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + triangle.get(i).get(j);
                }

                if (i == n - 1)
                    min = Integer.min(dp[i][j], min);
            }
        }
        return min;
    }
}
