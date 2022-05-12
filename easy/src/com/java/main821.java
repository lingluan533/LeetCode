package com.java;

import java.util.ArrayList;

/**
 * @author: zms
 * @create: 2022/4/19 9:56
 */
public class main821 {
    public int[] shortestToChar(String s, char c) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == c){
                list.add(i);
            }
        }
        int res[] = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            int min = Math.abs(list.get(0) - i);
            for(int j = 1 ;j < list.size() ; j++){
                if(Math.abs(list.get(j) - i) <= min){
                    min = Math.abs(list.get(j) - i);
                }else break;
            }
            res[i] = min;
        }

return res;
    }

}
