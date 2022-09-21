package com.java;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/9/1 14:43
 */
public class main154401 {
    static ArrayList<Integer> list = new ArrayList<>();
    public String makeGood(String s) {


        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<s.length();i++){
           if( Math.abs(stack.peek()-s.charAt(i))==32 ){ stack.pop();}else stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
