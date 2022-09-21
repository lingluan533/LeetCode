package com.java;

/**
 * @author: zms
 * @create: 2022/8/12 0:04
 */
public class main1417 {
    public String reformat(String s) {
        String num = "";
        String chars = "";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c))num+=c+"";
            else chars+=c+"";
        }
        if(Math.abs(num.length()-chars.length()) >1) return "";
        String res ="";
        if (num.length() < chars.length()){
            String tem =num;
            num = chars;
            chars = tem;
        }
        int i= 0,j=0;
        while(true){
            boolean flag = false;
            if(i<num.length()) {
                res+=num.charAt(i++);
                flag = true;
            }
            if (j<chars.length()) {
                res +=chars.charAt(j++);
                flag = true;
            }
            if (!flag)break;
        }
        return res;
    }
}

