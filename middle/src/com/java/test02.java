package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/3/22 16:30
 */
public class test02 {
    public String smallestSubsequence(String s) {
        boolean inStack[] = new boolean[123];
        Stack<Character> stack = new Stack<>();
        char cs[] = s.toCharArray();
        int count[] = new int[123];
        for(Character c: cs){
            count[c] ++;
        }

        for (Character c : cs){
            count[c]--;
            if(inStack[c]) continue;
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()]>0){
                inStack[stack.pop()]=false;
            }
            stack.push(c);

            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
