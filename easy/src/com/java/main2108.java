package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2021/12/25 9:22
 */

public class main2108 {
    public String firstPalindrome(String[] words) {
    for(String s:words){
    if(isP(s)){
        return s;
    }

}
    return "";
    }

    private boolean isP(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        if (stringBuilder.reverse().toString().equals(s)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
