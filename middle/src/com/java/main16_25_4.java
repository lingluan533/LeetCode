package com.java;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: zms
 * @create: 2021/12/23 22:11
 */

 class LRUCache4
{
    LinkedHashMap<Integer,Integer> map = null;
    int capacity;
    public LRUCache4(int capacity) {
      map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if(map.containsValue(key)){
            Integer value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return  value;

        }else{
            return -1;
        }

    }


    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        map.put(key,value);
          if(map.size() > capacity){
              map.remove(map.keySet().iterator().next());
          }
    }

}
public class main16_25_4 {

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(2,14);
        linkedHashMap.put(4,44);
        linkedHashMap.put(2,77);
        linkedHashMap.put(47,10);
        linkedHashMap.get(4);
        Set<Integer> keys = linkedHashMap.keySet();
        Iterator<Integer> iterator = keys.iterator();
       while (iterator.hasNext()){
           Integer i = iterator.next();
           System.out.println(i +" "+ linkedHashMap.get(i));
       }
    }
}
