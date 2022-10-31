package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/10/4 11:38
 */
public class main567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int need = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int lens1 = s1.length();
        int lens2 = s2.length();
        int right = 0, left = 0;
        while (right < lens2) {
            char cur = s2.charAt(right);
            if (need == 0) return true;
            if (map.containsKey(cur)) {
                if (map.get(cur) > 0) {
                    map.put(cur, map.get(cur) - 1);
                    need--;
                } else {
                    // ==0 则说明不需要这个字符了
                }

            } else if (!map.containsKey(cur)) {
                for (int i = 0; i < s1.length(); i++) {
                    map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
                }
                need = s1.length();
            } else if (map.get(cur) == 0) {

            }
            right++;
        }
        return false;

    }
}
