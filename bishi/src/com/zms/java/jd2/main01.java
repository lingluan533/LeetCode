package com.zms.java.jd2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/3 18:54
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = scan.nextInt();
            if (cur > max) {
                map.put(cur, 1);
            } else if (cur == max) {
                map.put(max, map.get(max) + 1);
            }
        }
        System.out.println(n - map.get(max));
    }
}
