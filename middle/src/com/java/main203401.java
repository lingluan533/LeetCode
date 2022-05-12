package com.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author: zms
 * @create: 2022/1/23 13:25
 */
class StockPrice1 {
    private HashMap<Integer,Integer> map ;

    private int lasttime = 0; //找最新价格

    private TreeMap<Integer,Integer> treeMap;
    public StockPrice1() {
        this.map = new HashMap<>();
        this.treeMap  = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
      if(treeMap.containsKey(price)){

          treeMap.put(price,treeMap.get(price)+1);
      }else{
          treeMap.put(price,1);
      }
      if(map.containsKey(timestamp)){
          treeMap.put(map.get(timestamp),treeMap.get(map.get(timestamp)) - 1 );
          if(treeMap.get(map.get(timestamp) ) == 0){
              treeMap.remove(map.get(timestamp));
          }
      }
        map.put(timestamp,price);

        if(lasttime < timestamp){
            lasttime = timestamp;
        }


    }

    public int current() {
        return map.get(lasttime);
    }

    public int maximum() {
        return  treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}
public class main203401 {

}
