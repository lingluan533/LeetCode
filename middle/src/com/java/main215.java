package com.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2021/12/28 17:36
 */
public class main215 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(Integer i : nums){
            if(!pq.contains(i))
                pq.add(i);
        }



        while(k>1){
            pq.poll();
            k--;
        }
            return pq.peek();
}

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
