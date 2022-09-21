package com.zms.java.mircsoft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/8/19 19:01
 */
public class maina2 {
    public static void main(String[] args) {
        System.out.println(solution("54321"));
    }
    public static String solution(String S) {
        // write your code in Java 8 (Java SE 8)
        PriorityQueue<Character> single = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Character> doubl = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        HashMap<Character,Integer> map = new HashMap();
       for (int i = 0;i<chars.length;i++){
           Integer orDefault = map.getOrDefault(chars[i], 0);
           map.put(chars[i],orDefault+1);
       }
       for (Character c : map.keySet()){
           if(map.get(c)%2==0){
               doubl.add(c);
           }else{
               if (map.get(c)==1) single.add(c);
               else {
                   single.add(c);
                   doubl.add(c);
               }
           }
       }
       String mid = "";
       if (!single.isEmpty()){
           mid += single.poll();
       }
       StringBuilder right =new StringBuilder("");
        while (!doubl.isEmpty()){
            Character poll = doubl.poll();
            int count = map.get(poll);
            String t="";
            for(int i=0;i<count/2;i++){
                t+=poll;
            }
            right.append(t);
        }
        String ress = right.reverse()+mid+right;
        if (ress.startsWith("0")) return mid==""?"0":mid;
        return ress;
    }
}
