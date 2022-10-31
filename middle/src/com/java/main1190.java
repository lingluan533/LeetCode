package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/10/16 15:28
 */
public class main1190 {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("((eqk((h))))"));
    }

    public static String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (Character.isLetter(cur)) { // 是字母
                int j = i;
                StringBuilder stringBuilder = new StringBuilder();
                while (Character.isLetter(s.charAt(j))) {
                    j++;
                }
                String t = s.substring(i, j);
                stack.push(t);
                i = j - 1;

            } else if (cur == ')' && s.charAt(i - 1) != '(') {
                if (!stack.isEmpty()) {
                    StringBuilder st = new StringBuilder(stack.pop());
                    StringBuilder stt;
                    if (!stack.isEmpty()) {
                        stt = new StringBuilder(stack.pop());
                    } else stt = new StringBuilder();
                    stt.append(st.reverse().toString());
                    //处理）左括号后面的字符串
                    if (i < s.length() - 1) {
                        Character c = s.charAt(i + 1);
                        if (Character.isLetter(c)) { // 是字母
                            int j = i + 1;
                            StringBuilder stringBuilder = new StringBuilder();
                            while (Character.isLetter(s.charAt(j))) {
                                j++;
                            }
                            String t = s.substring(i + 1, j);
                            stt.append(t);
                            i = j - 1;
                        }
                    }

                    stack.push(stt.toString());
                }
            }
        }
        return stack.pop().toString();
    }
}
