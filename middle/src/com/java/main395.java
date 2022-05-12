package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/3/15 12:00
 */
public class main395 {

    public int longestSubstring(String s, int k1) {
        int max = Integer.MIN_VALUE;
        if(k1 > s.length()) return 0;
        for(int i = 0;i<s.length();i++){ //子串的start
            for(int j = i+1;j<=s.length();j++){          //子串的end
                String curs = s.substring(i,j);
                HashMap<Character,Integer> map = new HashMap<>();
                for(int k=0;k<curs.length();k++){
                    map.put(curs.charAt(k),map.getOrDefault(curs.charAt(k),0)+1);
                }
                boolean flag = true;
                for(Character c : map.keySet()){
                    if(map.get(c)<k1){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    max = Math.max(j-i,max);
                }

            }
        }
        return max;
    }
}
