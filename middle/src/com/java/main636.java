package com.java;

import java.util.List;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/8/7 22:21
 */
public class main636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int res[] = new int[n];
        int cur = -1;
        Stack<Integer> stack = new Stack<>();
        for (String s :logs){
           String[] ss =  s.split(":");
           if(ss[1].equals("start")){
               if(!stack.isEmpty())
               res[stack.peek()]+=Integer.parseInt(ss[2]) -cur;
               stack.push(Integer.parseInt(ss[0]));
               cur = Integer.parseInt(ss[2]);
           }else{
               res[stack.pop()] += Integer.parseInt(ss[2]) - cur+1;
               cur = Integer.parseInt(ss[2])+1;
           }
        }
        return res;
    }
}
