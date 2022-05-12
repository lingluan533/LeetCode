package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/2/17 0:29
 */
public class main946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0 ;
        int j = 0 ;
        int len = pushed.length;
        for( i = 0;i<len;i++){
            if(pushed[i] == popped[j]){
                j++;
               while(j<len && stack.peek() == popped[j]){
                   stack.pop();
                   j++;
               }
            }else{
                stack.push(pushed[i]);
            }
        }
        return stack.isEmpty();
    }
}
