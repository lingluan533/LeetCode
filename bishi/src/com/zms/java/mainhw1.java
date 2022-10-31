package com.zms.java;

import java.util.HashSet;

/**
 * @author: zms
 * @create: 2022/10/26 14:44
 */
public class mainhw1 {
    public static void main(String[] args) {
        System.out.println(getNorepeat("bbbbb"));
    }

    public static int getNorepeat(String s) {
        HashSet<Character> set = new HashSet<>();
        char cs[] = s.toCharArray();
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (!set.contains(cs[j])) {
                    set.add(cs[j]);
                } else {
                    max = Math.max(max, j - i);
                    i = j - 1;
                    set.clear();
                    break;
                }
            }
        }
        return max;
    }
}
