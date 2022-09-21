package com.java.week306;

import java.util.HashSet;

/**
 * @author: zms
 * @create: 2022/8/14 10:25
 */
public class main1 {
    public static void main(String[] args) {
        for (int i = 1;i<=1000;i++){
            System.out.println(i);
        }
    }
    public int countSpecialNumbers(int n) {
        int count = 0;
        for (int i= 1;i<=n;i++){
            if(check(i+"")){
                count++;
            }
        }
        return n - count;
    }

    private boolean check(String s) { //如有重复则返回true  非特殊+1
        HashSet<Character> set = new HashSet<>();
        for(int i =0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                return true;
            }
            set.add(s.charAt(i));
        }
        return false;
    }
}
