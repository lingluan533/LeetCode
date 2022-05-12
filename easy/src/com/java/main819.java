package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/4/20 14:34
 */
public class main819 {
    public static void main(String[] args) {
        //String a [] = new String[]{"hit"};
       // String aa = "Bob hit a ball, the hit BALL flew far after it was hit.";



                String aa = "a, a, a, a, b,b,b,c, c";
                String a[] = new String[]{"a"};
        System.out.println(mostCommonWord(aa, a));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> list = Arrays.asList(banned);
        HashMap<String,Integer> map = new HashMap<>();
        int j = 0;
        List<String> temp = new ArrayList<>();
        for (String   s : paragraph.split(" ")){

            if(s.contains(",") ){
                s = s.replace(',',' ');
            }
            if(s.contains("!")){
               s= s.replace('!',' ');
            }
            if(s.contains("?") ){
               s= s.replace('?',' ');
            }
            if(s.contains("'") ){
                s = s.replace('\'',' ');
            }
            if(s.contains(";") ){
               s =  s.replace(';',' ');
            }
            if(s.contains(".") ){
                s = s.replace('.',' ');
            }
            if(list.contains(s)) continue;

            String[] s1 = s.split(" ");
            for (int i = 0;i<s1.length;i++){
                String ss = s1[i].trim().toLowerCase();
                if(list.contains(ss)) continue;
                temp.add(ss);
            }
        }

        for(int i = 0;i< temp.size();i++){
            if(map.containsKey(temp.get(i))){
                map.put(temp.get(i), map.get(temp.get(i))+1);
            }else{
                map.put(temp.get(i),1);
            }
        }

        int max = 0;
        String maxstr = "";
        Set<String> strings = map.keySet();

        for(String s : strings){

           if(map.get(s) > max){
               max = Math.max(map.get(s),max);
               maxstr = s;
           }
        }
        return maxstr;
    }
}
