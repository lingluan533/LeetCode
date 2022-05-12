package com.java;

/**
 * @author: zms
 * @create: 2021/12/25 9:30
 */
public class main2109 {
    public String addSpaces(String s, int[] spaces) {
       char[] cs = s.toCharArray();
       int ans = 0;
       StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (ans < spaces.length &&i==spaces[ans]){
                stringBuilder.append(" ");
                ans ++;

            }stringBuilder.append(cs[i]+"");
        }
    return stringBuilder.toString();
    }

    public static void main(String[] args) {

    }
}
