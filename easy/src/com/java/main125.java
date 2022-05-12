package com.java;

/**
 * @author: zms
 * @create: 2022/1/12 17:51
 */
public class main125 {
    public static void main(String[] args) {
isPalindrome("0P");
    }
    public static boolean isPalindrome(String s) {
       s =  s.replace(" ","");
       s =  s.replace(",","");
       s = s.replace(":","");
       if(s.length()==0 || s.length() == 1) return true;
       int l = 0,r= s.length()-1;
       char cs [] = s.toCharArray();
       while(l<=r){
           if(!Character.isLetterOrDigit(cs[l])){
               l++;
               continue;
           }
           if(!Character.isLetterOrDigit(cs[r])){
               r--;
               continue;
           }
            if(l==r) return true;
           if(Character.toLowerCase(cs[l]) == Character.toLowerCase(cs[r])){
                l++;
                r--;
           }else{
               return false;
           }
       }

        return true;
    }
}
