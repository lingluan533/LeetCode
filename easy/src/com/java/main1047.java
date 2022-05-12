package com.java;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/1/22 13:47
 */
public class main1047 {
    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){

                if(!stack.isEmpty()&&stack.peek()==c){
                    stack.pop();
                    continue;
                }
                stack.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();



    }
}
