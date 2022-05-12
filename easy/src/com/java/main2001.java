package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/4/4 15:39
 */
public class main2001 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            switch(c){
                case '(':
                    stack.push(')');
                    continue;
                case '{':
                    stack.push('}');
                    continue;
                case '[':
                    stack.push(']');
                    continue;
                default:
                    if(stack.isEmpty()){
                        return false;
                    }
                    Character pop = stack.peek();
                    if(pop.equals(c)){
                        stack.pop();
                    }else return false;
            }
        }
        return stack.isEmpty()? true : false;
    }
}
