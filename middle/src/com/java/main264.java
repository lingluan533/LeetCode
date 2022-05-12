package com.java;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/3/19 21:51
 */
public class main264 {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        queue.add(1L);
        int count = 0;
        while (!queue.isEmpty()){
            Long i = queue.poll();
            count++;
            if(count== n ) return i.intValue();
            if(!set.contains(i*2))
            queue.add(i*2);
            if(!set.contains(i*3))
            queue.add(i*3);
            if(!set.contains(i*5))
            queue.add(i*5);
        }
        return 0;

    }
}
