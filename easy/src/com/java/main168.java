package com.java;

import com.java.double71.main;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/3/3 10:28
 */
public class main168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(702));
    }
    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while(columnNumber!=0){
            int cur = columnNumber%26;
            if(cur ==0 && columnNumber/26 <= 26){
                stack.push('Z');
                if(columnNumber/26>1){
                    stack.push((char)(columnNumber/26+63));
                }
                break;
            }else if(cur == 0 && columnNumber/26 > 26){
                    stack.push('Z');
//                    columnNumber = columnNumber%26 + ;
                    continue;
            }


            //stringBuilder.append((char)(cur + 64)+"");
            stack.push((char)(cur + 64));
            columnNumber = columnNumber / 26;
        }
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop()+"");
        }
        //stringBuilder.append((char)(columnNumber + 64)+"");
        return stringBuilder.toString();
    }
}
