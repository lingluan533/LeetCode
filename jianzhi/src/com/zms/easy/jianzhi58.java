package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/1/8 23:45
 */
public class jianzhi58 {
    public String reverseLeftWords(String s, int n) {
        if(n == s.length() ) return s;
        String tem = s.substring(0,n);
        String tem1 = s.substring(2);


        return tem1+tem;
    }
}
