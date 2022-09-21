package com.java;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/9/9 9:31
 */
public class main34701 {
    class Node {
        int key;
        int fre;

        public Node(int _key, int _fre) {
            this.key = _key;
            this.fre = _fre;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> {
            return o1.fre - o2.fre;
        });
      
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return new int[]{};
    }
}
