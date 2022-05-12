package com.java;

/**
 * @author: zms
 * @create: 2022/1/9 23:20
 */
public class main647 {
    public static void main(String[] args) {
        countSubstrings("abcd");
    }
    public static int countSubstrings(String s) {
       if(s.length()==1) return 1;
       int len = s.length();
       int count = s.length();
       for(int i =0;i<s.length();i++){
           for(int j = i+2;j<=s.length();j++){
               if(isPara(s.substring(i,j))){
                   count++;
               }
           }
       }
        return count;
    }

    private static boolean isPara(String substring) {
            int i = 0;
            int j = substring.length()-1;
            while(i<j){
                if(substring.charAt(i) == substring.charAt(j)){
                    i++;
                    j--;
                }else{
                    return false;
                }
            }
            return true;
    }


}
