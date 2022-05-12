package com.java;

/**
 * @author: zms
 * @create: 2022/3/29 15:00
 */
public class main415 {
    public String addStrings(String num1, String num2) {

        String res = "";
        int i = num1.length()-1;
        int j = num2.length()-1;
        int jinwei = 0;
        while(i >= 0 || j>=0|| jinwei !=0){
            if(i>=0) jinwei += num1.charAt(i--)-'0';
            if(j>=0) jinwei += num2.charAt(j--)-'0';

            res = jinwei %10 + res;
            jinwei = jinwei /10;
        }
        return res;

    }
}
