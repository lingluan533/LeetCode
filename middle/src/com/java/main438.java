package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/15 23:58
 */
public class main438 {
    public static void main(String[] args) {
        findAnagrams("cbaebabacd","abc");
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0) +1 );
        }
        int plen = p.length();
        int slen = s.length();
        for(int i = 0 ; i<= slen - plen ;i++){
            HashMap<Character, Integer> temmap  = new HashMap<>();
            temmap.putAll(map);
            boolean flag = false ;

            for(int j = i;j<i+plen && i+plen < s.length();j++){
                if(!map.containsKey(s.charAt(j))){
                    i = j;
                    flag = true;
                    break;
                }else{
                    int count = temmap.getOrDefault(s.charAt(j),0);
                    if(count ==0){
                        flag = true;
                        break;
                    }else if(count>1){
                        temmap.put(s.charAt(j),count -1);
                    }else  if(count==1){
                        temmap.remove(s.charAt(j));
                    }

                }
            }
            if(!flag){
                res.add(i);
            }
        }
        return res;
    }
}
