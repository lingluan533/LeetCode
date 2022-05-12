package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/1/19 22:37
 */
public class main232 {
    class MyQueue {
        Stack a ;
        Stack b ;
        public MyQueue() {
            this.a =  new Stack();
            this.b =  new Stack();
        }

        public void push(int x) {
            a.push(x);
        }

        public int pop() {
            while(!a.isEmpty()){
                b.push(a.pop());
            }
            int tem = (int) b.pop();
            while(!b.isEmpty()){
                a.push(b.pop());
            }
            return tem;
        }

        public int peek() {
            while(!a.isEmpty()){
                b.push(a.pop());
            }
            int tem = (int) b.peek();
            while(!b.isEmpty()){
                a.push(b.pop());
            }
            return tem;
        }

        public boolean empty() {
            return a.isEmpty();
        }
    }
}
