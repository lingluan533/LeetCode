package com.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/1/22 12:52
 */
public class main189 {
    public void rotate(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0;i< nums.length;i++){
         queue.add(nums[i]);
        }
        for(int i = 0;i<k;i++){
            queue.addFirst(queue.getLast());
            queue.removeLast();
        }
        int i =0;
        while(!queue.isEmpty()){
            nums[i++] = queue.removeFirst();
        }
    }
}
