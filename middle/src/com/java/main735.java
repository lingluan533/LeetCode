package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/8/29 22:20
 */
public class main735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0;i<asteroids.length;i++){
            if (asteroids[i]>0){
                stack.push(asteroids[i]);
            }else{//向左走
                if(stack.isEmpty()){
                    res.add(asteroids[i]);
                    continue;
                }
                int top = stack.peek();
                if (top > asteroids[i]*-1){ // 左走的自身毁灭
                    continue;
                }else{
                    if (top == asteroids[i]*-1){    // 两败俱伤
                        stack.pop();
                        continue;
                    } else{             // 一直毁灭
                        stack.pop();
                        i--;
                    }
                }
            }
        }
        Stack<Integer> t = new Stack<>();
        while (!stack.isEmpty()){
            t.push(stack.pop());
        }
        while (!t.isEmpty()){
            res.add(t.pop());
        }
       int resary [] = new int[res.size()];
        for (int i =0;i<res.size();i++){
            resary[i] = res.get(i);
        }
return resary;
    }
}
