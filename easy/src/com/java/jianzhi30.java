package com.java;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2021/12/24 22:24
 */
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = null;
    PriorityQueue<Integer> pq;
    int min = Integer.MAX_VALUE;
    public MinStack() {
    stack = new Stack<>();
    pq = new PriorityQueue<>();
    }

    public void push(int x) {
        pq.add(x);
        stack.push(x);
    }

    public void pop() {

//        if(stack.peek() == pq.peek()){
//            pq.poll();
//            stack.pop();
//        }else{
            pq.remove( stack.pop());
      //  }

    }

    public int top() {
        return  stack.peek();
    }

    public int min() {
        return  pq.peek();
    }
}

public class jianzhi30 {


}
