package com.java;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/9/25 18:15
 */
public class main31601 {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Boolean> inStack = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (inStack.getOrDefault(cur, false)) {
                map.put(cur, map.get(cur) - 1);
                continue;
            }
            // 看前面的字母是否字典序大于当前字母并且 “后面还有前面出现过的字母” ，这时候就需要将前面的字母出栈，等后面再遇见该字母时候再入栈
            while (!stack.isEmpty() && stack.peek() > cur && map.getOrDefault(stack.peek(), 0) > 0) {
                inStack.put(stack.peek(), false);
                map.put(stack.peek(), map.get(stack.peek()) - 1);
                stack.pop();
            }
            stack.push(cur);
            inStack.put(cur, true);
            map.put(cur, map.get(cur) - 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
