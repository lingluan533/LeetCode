package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/10/16 22:14
 */
public class main2201 {
    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        dfs(2 * n, new StringBuilder());
        return list;
    }

    private void dfs(int len, StringBuilder stringBuilder) {
        if (stringBuilder.length() == len) {
            if (check(stringBuilder.toString())) {
                list.add(stringBuilder.toString());
            }
            return;
        }
        stringBuilder.append('(');
        dfs(len, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(')');
        dfs(len, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }

    private boolean check(String s) {
        int balance = 0;
        char[] current = s.toCharArray();
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

}
