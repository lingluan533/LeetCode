package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2021/12/24 22:08
 */

class CQueue {
    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;
    public CQueue() {
stack1 = new Stack();
stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()){
            return  -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.peek();
        stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
}
public class jianzhi09 {
}
