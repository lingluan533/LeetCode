package com.zms.java.ali.mayi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/15 19:15
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer n = scan.nextInt();
        String s = Integer.toBinaryString(n);
        String res = "";
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(4, 'c');
        map.put(8, 'd');
        map.put(16, 'e');
        map.put(32, 'f');
        map.put(64, 'g');
        map.put(128, 'h');
        map.put(256, 'i');
        map.put(512, 'j');
        map.put(1024, 'k');

        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res += map.get((int) Math.pow(2, s.length() - i - 1));
            }
        }
        System.out.println(res);

    }
}
