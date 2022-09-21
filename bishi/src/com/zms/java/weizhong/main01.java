package com.zms.java.weizhong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/13 20:18
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int arr[] = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);

        boolean vis[] = new boolean[a];
        vis[a - 1] = true;
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(arr[a - 1]);
        dfs(0, vis, arr[a - 1], arr, objects);
        
        System.out.println(max);
    }

    static long max = 0;

    private static void dfs(int start, boolean[] vis, long sum, int arr[], ArrayList<Integer> list) {
        if (list.size() == 3) {
            max = Long.max(sum, max);
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i]) continue;
            String as = arr[i] + "";
            vis[i] = true;
            long tsum = sum;
            sum = sum * (long) Math.pow(10, as.length()) + arr[i];
            list.add(arr[i]);
            dfs(i, vis, sum, arr, list);
            sum = tsum;
            vis[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
