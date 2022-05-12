package com.java;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author: zms
 * @create: 2022/3/18 21:25
 */

public class LRUCache1 {
    public LinkedList<Integer> list;
    public LinkedHashMap map ;
    public Integer max ;
    public LRUCache1(int capacity) {
        this.map = new LinkedHashMap(capacity);
        this.list = new LinkedList<>();
        this.max = capacity;
    }

    public int get(int key) {
       if(map.containsKey(key)){
           Integer res = (Integer)map.get(key);
           //执行放入链表尾部的逻辑
           list.remove((Integer)key);
            list.addLast((Integer)key);
            return res.intValue();  //可以自动拆装箱
       }else{
           return -1;
       }
    }

    public void put(int key, int value) {
       if(map.containsKey(key)){
           map.put(key,value);
           list.remove((Integer)key);
           list.addLast((Integer)key);
       }else{
           if(map.size() == max){
               map.remove((Integer)list.getFirst());
               list.removeFirst();
           }
           map.put(key,value);
           list.addLast((Integer)key);
       }
    }
}
