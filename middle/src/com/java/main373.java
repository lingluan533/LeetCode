package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/1/15 0:34
 */
public class main373 {
    public static void main(String[] args) {
        kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},9);
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - (nums1[o2[0]] + nums2[o2[1]]);
            }


        });
        int m = nums1.length;;
        int n = nums2.length;
        for(int i = 0;i<m;i++){
            pq.offer(new int[]{i,0});
           // pq.add(new int[]{i,0});
        }


        int count = 1;
        while(count <= k && !pq.isEmpty()){
            List<Integer> t = new ArrayList<>();
            int a [] = pq.poll();

            res.add(Arrays.asList(nums1[a[0]],nums2[a[1]]) );
            if(++a[1] < n)pq.add(a);

        }
        return res;
    }
}
