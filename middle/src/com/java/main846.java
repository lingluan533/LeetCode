package com.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2021/12/30 10:55
 */
public class main846 {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if(len % groupSize !=0)return false;
        if(1 == groupSize) return true;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for(int i = 0;i<len;i++){
            System.out.print(hand[i]+" ");
        }
        System.out.println();
        for(int i = 0;i<len;i++){
            if(!pq.contains(hand[i])){
                pq.add(hand[i]);
            }
            if(!map.containsKey(hand[i])){
                map.put(hand[i],1);
            }else{
                map.put(hand[i],map.get(hand[i])+1);
            }
        }
        Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        int curfirst = 0;
        int i = 1;
        while(!pq.isEmpty()){
            //检查队列的第一个元素让其成对
            curfirst = pq.peek();
            boolean flag = false;
            int next = 0;


            for( i=1;i<groupSize;i++){
                next = curfirst + i;
                if(map.containsKey(next)){
                    map.put(next,map.get(next)-1);
                    if(map.get(next) == 0){
                        map.remove(next);
                        if (pq.contains(next)){
                            pq.remove(next);
                        }
                    }
                }else{
                    return false;
                }
            }

            if(map.get(curfirst)>1){
                map.put(curfirst,map.get(curfirst)-1);
            }else{
                map.remove(curfirst);
                pq.poll();
            }
        }
        return map.isEmpty()? true:false;
    }

    public static void main(String[] args) {
        isNStraightHand(new int[]{9,13,15,23,22,25,4,4,29,15,8,23,12,19,24,17,18,11,22,24,17,17,10,23,21,18,14,18,7,6,3,6,19,11,16,11,12,13,8,26,17,20,13,19,22,21,27,9,20,15,20,27,8,13,25,23,22,15,9,14,20,10,6,5,14,12,7,16,21,18,21,24,23,10,21,16,18,16,18,5,20,19,20,10,14,26,2,9,19,12,28,17,5,7,25,22,16,17,21,11},
        10);
    }
}
