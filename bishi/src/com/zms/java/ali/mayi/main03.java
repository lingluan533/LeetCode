package com.zms.java.ali.mayi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/15 19:37
 */
public class main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (int k = i; k <= j; k++) {
                    char kc = s.charAt(k);
                    map.put(kc, map.getOrDefault(kc, 0) + 1);
                }
                int countOdd = 0;
                for (Character c : map.keySet()) {
                    if (map.get(c) % 2 != 0) {
                        countOdd++;
                        if (countOdd > 1) break;
                    }
                }
                if (countOdd == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
