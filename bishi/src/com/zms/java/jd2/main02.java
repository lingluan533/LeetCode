package com.zms.java.jd2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/3 18:54
 */
public class main02 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ary[] = new int[n];
        int max = 0;
        boolean isPa[];
        for (int i = 0; i < n; i++) {
            ary[i] = scan.nextInt();
            max = Math.max(max, ary[i]);
        }

        isPa = new boolean[max + 5];  //默认全是素数
        isPa[2] = true;
        isPa[3] = true;
        for (int i = 2; i < max; i++) {
            if (isPa[i])
                for (int j = 1; j * i <= max; j++) {
                    isPa[i * j] = true;
                }
        }
        isPa[2] = false;
        isPa[3] = false;
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(ary[i])) count += map.get(ary[i]);
            else {
                int t = getNum(ary[i], map, isPa);
                map.put(ary[i], t);
                count += t;
            }
        }
        System.out.print(count);
    }

    private static int getNum(int cur, HashMap<Integer, Integer> map, boolean isPa[]) {
        if (cur == 1) return 0;
        if (cur == 2) return 1;
        int left = 0, right = 0;
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        if (!isPa[cur]) {
            left = 1;
            right = cur - 1;
        } else {
            for (int i = 2; i <= Math.sqrt(cur); i++) {
                if (cur % i == 0) {
                    left = i;
                    right = cur / i;
                    break;
                }
            }
        }
        return getNum(left, map, isPa) + getNum(right, map, isPa) + 1;
    }
}
