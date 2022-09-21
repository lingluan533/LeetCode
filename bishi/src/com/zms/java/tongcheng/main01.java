package com.zms.java.tongcheng;

/**
 * @author: zms
 * @create: 2022/9/7 19:13
 */
public class main01 {
    public static void main(String[] args) {

    }

    public String longestPrefix(String s) {
        // write code here
        if (s.length() == 1) return s;
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(0, i);
            if (s.endsWith(t)) {
                res = t;
            }
        }
        return res;
    }
}
