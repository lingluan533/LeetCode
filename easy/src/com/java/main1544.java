package com.java;

import java.util.HashSet;

/**
 * @author: zms
 * @create: 2022/9/1 12:06
 */
public class main1544 {
    public static void main(String[] args) {
      //  System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("leEeetcode"));
    }
    public static String makeGood(String s) {
        int len = s.length();
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while(flag){

            HashSet<Integer> set = new HashSet<>();
            boolean flag1 = false;
            for(int i = 0;i<s.length()-1;i++){
                if(Math.abs(s.charAt(i)-s.charAt(i+1)) != 32){
                    continue;
                }
                set.add(i);
                set.add(i+1);
                flag1 = true;
                i++;
            }


            if(!flag1){
                flag = false;
            }else {
                for(int i = 0;i<s.length();i++){
                    if(!set.contains(i)) sb.append(s.charAt(i));
                }
                flag = true;
                //
                s = sb.toString();
            }
            sb.delete(0,sb.length());

        }

        return sb.toString();
    }
}
