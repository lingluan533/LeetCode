package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/10/30 11:03
 */
public class main784 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCasePermutation("3z4").toArray()));
    }

    static ArrayList<String> res;

    public static List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        dfs(s, 0, new StringBuilder());
        return res;
    }

    private static void dfs(String s, int start, StringBuilder stringBuilder) {
        if (start == s.length() && stringBuilder.length() == s.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
                dfs(s, i + 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                char cur = s.charAt(i);
                stringBuilder.append(cur);
                dfs(s, i + 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                if (Character.isLowerCase(cur)) {
                    stringBuilder.append(Character.toUpperCase(cur));
                    dfs(s, i + 1, stringBuilder);
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    stringBuilder.append(Character.toLowerCase(cur));
                    dfs(s, i + 1, stringBuilder);
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }

            }
        }
    }
}
