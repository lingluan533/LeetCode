package com.zms.java.glda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/8/31 20:38
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<T;i++){
            stack1.push(scan.nextInt());
        }
        ArrayList<Integer> li = new ArrayList<>();
        for (int j=0;j<T;j++){
            li.add(scan.nextInt());
        }
        int count = 0;
        HashSet<Integer> unNormal = new HashSet<>();
        while (!stack1.isEmpty()){
            stack.push(stack1.pop());
        }
        for (int j=0;j<T;j++){
            int peek = stack.peek();
            if (unNormal.contains(peek)) {stack.pop();
            continue;}
            if (peek == li.get(j)){
                stack.pop();
            }else{
                unNormal.add(li.get(j));
                count++;
            }
        }
        System.out.println(count);

    }
}

