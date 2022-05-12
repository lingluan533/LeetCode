package com.java;

/**
 * @author: zms
 * @create: 2022/1/2 10:31
 */
public class main5967 {
    public static boolean checkString(String s) {
    if(!s.contains("a")) return true;
    if(!s.contains("b")) return true;
    if(s.length()==1) return true;
    int maxA = 0;
    int minB = Integer.MAX_VALUE;
    boolean flag = false;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='a') maxA = Math.max(i,maxA);
        else if(s.charAt(i)=='b') {
            minB = Math.min(minB,i);
            flag = true;
        }

        if(maxA > minB && minB >=0 && flag) return false;
    }
    return true;
    }

    public static void main(String[] args) {
        checkString("bbbabbbabaaabbabaaabbbbaaabaaaaaabaaabaaaaabbbbaabbabbbabbababbaabbbabbbbabbabbbabbaabababababbbaaab");
    }
}
