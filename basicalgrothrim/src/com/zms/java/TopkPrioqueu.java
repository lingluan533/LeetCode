package com.zms.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/3/17 18:03
 */
public class TopkPrioqueu {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i = 0;i<k;i++){
            queue.add(nums[i]);
        }
//O(N)
        for(int i = k;i< nums.length;i++){
            Integer peek = queue.peek();
            if(nums[i] > peek){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}
