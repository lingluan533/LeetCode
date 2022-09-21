package com.zms.java.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/4 19:55
 */
public class main010 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int ary[] = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = scan.nextInt();
        }

        int mod = 1000000000;
        Arrays.sort(ary);
        dfs(ary, new boolean[n], k, 0, 0);
        System.out.println(maxCount);
    }

    static int maxCount = Integer.MIN_VALUE;
    static int maxW = Integer.MIN_VALUE;
    static int mod = 1000000000;

    private static void dfs(int[] ary, boolean[] vis, int k, long sum, int count) {
        for (int i = 0; i < ary.length; i++) {
            if (vis[i]) continue;
            int cur = ary[i];
            long tsum = sum;
            int tmax = maxW;
            sum = (sum + ary[i]) % mod;
            count++;
            maxW = (Math.max(maxW, cur));
            if (maxW <= (sum / count) * k) {
                maxCount = Math.max(maxCount, count);
                vis[i] = true;
                dfs(ary, vis, k, sum, count);
                sum = tsum;
                count--;
                vis[i] = false;
                maxW = tmax;
            } else {
                sum = tsum;
                count--;
                maxW = tmax;
            }

        }
        return;
    }
}
