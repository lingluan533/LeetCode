package com.java;

/**
 * @author: zms
 * @create: 2022/4/24 20:05
 */
public class main67 {
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int cha = Math.abs(lena - lenb);
        String s0 = "";
        if(cha != 0){
            for(int i = 0;i<cha;i++){
                s0 += "0";
            }
        }
        if (lena > lenb){
            b = s0 + b;
        }else a = s0 + a ;
        int len = a.length();
        String res = "";
        char as [] = a.toCharArray();
        char bs [] = b.toCharArray();
        int jinwei = 0;
        for(int i = len - 1 ; i >= 0 ; i--){
            int sum = (as[i]-'0') +(bs[i] - '0') + jinwei;
            int cur = sum % 2 ;
            jinwei = sum / 2;
            res = cur + res;
        }

        if (jinwei == 1) res = 1 + res;
        return res;

    }
}
