package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/9/25 17:05
 */
public class main40201 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() > cur) {
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        String s = stringBuilder.reverse().toString();
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '0') continue;
            else break;
        }

        return i > 0 ? s.substring(i - 1) : s.equals("") ? "0" : s;

    }
}
