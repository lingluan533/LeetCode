package com.java;

import java.util.HashSet;

/**
 * @author: zms
 * @create: 2021/12/28 17:13
 */
public class main3 {
    public static void main(String[] args) {
        int b = 0;
        //b=b++;
       b=++b;
       Object o = new Object();
        System.out.println(b);
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        if (s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int j = i;
            while(j<len && !set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                     j++;
            }
            set.clear();
            if(j==len ){
                max = Math.max(max,j-i);
                continue;

            }else{
                max = Math.max(max,j-i);
                continue;
            }



        }


        return max;
    }
}
