package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/10/16 17:02
 */
public class main119001 {
    public static void main(String[] args) {
        reverseParentheses("(abcd)");
    }

    public static String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char cs[] = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                stack.push(i);
            } else if (cs[i] == ')') {
                reverse(cs, stack.pop(), i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(cs[i])) {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }

    private static void reverse(char[] cs, int i, int j) {

        while (i < j) {
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
            i++;
            j--;
        }

    }
}
