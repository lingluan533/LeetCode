package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/10/4 10:02
 */
public class main76 {
    public static void main(String[] args) {
        //  System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("aa", "aa"));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int lens = s.length();
        int lent = t.length();
        int start = 0, end = -1;
        int right = 0, left = 0;
        int minlen = lens + 1;
        int need = lent;
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < lens) {
            char cur = s.charAt(right);
            if (!map.containsKey(cur)) {
                right++;
                continue;
            }
            if (map.get(cur) > 0) {
                map.put(cur, map.get(cur) - 1);
                need--;
            } else {
                map.put(cur, map.get(cur) - 1);
            }
            while (need == 0) {
                char c = s.charAt(left);
                if (!map.containsKey(c)) {
                    left++;
                    continue;
                }
                if (map.get(c) == 0) {//窗口内没有多余的c字母 此时应该判断长度是不是新的最小的 然后再将左端点右移
                    if (right - left + 1 <= minlen) {
                        start = left;
                        end = right;
                        minlen = right - left + 1;
                        map.put(c, 1);
                        need++;
                        left++;
                    }
                    break;
                } else if (map.get(c) < 0) {
                    map.put(c, map.get(c) + 1);
                    left++;
                }
            }
            right++;
        }
        return s.substring(start, end + 1);
    }
}
