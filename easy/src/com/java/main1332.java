package com.java;

/**
 * @author: zms
 * @create: 2022/1/22 14:40
 */
public class main1332 {
    public int removePalindromeSub(String s) {
        if(isPali(s)){
            return 1;
        }else{
            return 2;
        }

    }
    public boolean isPali(String s ){
        int i = 0,j=s.length();
        while(i<=j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else return false;

        }
        return true;
    }
}
