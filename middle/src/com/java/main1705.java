package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2021/12/24 10:40
 */

public class main1705 {
    public static int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        if (n==1){
            return Math.min(apples[0],days[0]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList();
      for(int i = 0;i<n;i++){
          int applecount = apples[i];
          int expiretime = i + days[i];
          list.add(expiretime);
          if(map.containsKey(expiretime)){
              map.put(expiretime,map.get(expiretime) + applecount);
          }else{
              map.put(expiretime,applecount);
          }
      }
        Collections.sort(list);
      int day = 0;
      for (int i = 0;i<list.size();i++){
         if(list.get(i)>day){
             day += Math.min(map.get(list.get(i)), list.get(i) - day);
         }
      }

      for(Map.Entry e : map.entrySet()){
          System.out.println(e);
      }
return day;
    }

    public static void main(String[] args) {

        //System.out.println(eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println(eatenApples(new int[]{2, 1, 1, 4, 5}, new int[]{10, 10, 6, 4, 2}));
    }
}
