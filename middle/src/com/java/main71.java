package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/4/4 17:22
 */
public class main71 {
    public static void main(String[] args) {
        simplifyPath("/homme/");
    }
    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        System.out.println(split.length);

        Stack<String> stack =  new Stack<>();
        for(int i = 0;i<split.length;i++){
            System.out.println(split[i]);
            if(split[i].equals("")) continue;
            if(split[i].equals(".")){
                continue;
            }
            if(split[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
           stack.push(split[i]);
        }
        String res = "";
        while (stack.isEmpty() == false){
            res = "/"+stack.pop()+res;
        }
        if(res == "") res = "/";
        return res;
    }
}
