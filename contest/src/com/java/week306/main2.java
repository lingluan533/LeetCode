package com.java.week306;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/8/14 10:25
 */
public class main2 {
    public static void main(String[] args) {
        edgeScore(new int[]{1,0,0,0,0,7,7,5});
    }
    public static int edgeScore(int[] edges) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = edges.length;
        for(int i = 0;i<len;i++){
            Integer orDefault = map.getOrDefault(edges[i], 0);
            map.put(edges[i],orDefault + i);
            if (orDefault+i > max){
                pq.clear();
                pq.add(edges[i]);
                max = orDefault+i;
            }else if(orDefault+i==max){
                pq.add(edges[i]);
            }
        }
        return pq.poll();
    }
}
