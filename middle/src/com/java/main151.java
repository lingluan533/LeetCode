package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/4/4 16:06
 */
public class main151 {
    public static void main(String[] args) {

    }
    public String reverseWords(String s) {
       s =  s.trim();
        Stack <String> stack = new Stack<>();
        int start = 0;
        int end = 0;
       char cs [] = s.toCharArray();
//        int i1 = s.indexOf(' ');
//        s.substring(start,i1);
        for(int i = 1;i<s.length();i++){
            if(i==s.length()-1){
                stack.push(s.substring(start,i+1));
                break;
            }
            if(cs[i] == ' '){
                stack.push(s.substring(start,i));
                while(cs[i]==' '){
                    i++;
                }
                i-=1;
                start = i+1;
            }

        }
        StringBuilder sb  = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        return sb.toString().trim();
    }
}
