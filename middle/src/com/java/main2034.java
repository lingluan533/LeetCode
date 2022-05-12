package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/1/23 12:35
 */
class StockPrice {
    private HashMap<Integer,Integer> map ;
    private int lasttime = 0; //找最新价格
    private PriorityQueue<Integer> pq; //升序
    private PriorityQueue<Integer> pq1;//降序
    public StockPrice() {
    this.map = new HashMap<>();
    this.pq = new PriorityQueue<>();
    this.pq1 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    }

    public void update(int timestamp, int price) {

        if(map.containsKey(timestamp)){
            pq.remove(map.get(timestamp));
            pq1.remove(map.get(timestamp));
        }
        pq.add(price);
        pq1.add(price);
            map.put(timestamp,price);
            if(lasttime < timestamp){
                lasttime = timestamp;
            }


    }

    public int current() {
        return map.get(lasttime);
    }

    public int maximum() {
        return  pq1.peek();
    }

    public int minimum() {
        return pq.peek();
    }
}
public class main2034 {
}
