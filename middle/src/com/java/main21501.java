package com.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/1/15 11:03
 */
public class main21501 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0;i< nums.length;i++){
            pq.add(nums[i]);
        }
        while(k>0 && !pq.isEmpty()){
            if(k==1) return pq.poll();
            pq.poll();
        }
        return -1;
    }
}
