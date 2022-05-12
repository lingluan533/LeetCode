package com.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/1/15 14:19
 */
public class main78601 {
    public static void main(String[] args) {

    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k)
    {
        PriorityQueue<int []> pq  = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare(o2[0]*1.0/o2[1],o1[0]*1.0/o1[1]);
            }
        });
       for(int i = 0;i<arr.length;i++){
           for(int j = i+1;j<arr.length;j++){
               double t = arr[i] *1.0 / arr[j];
               if(pq.size() < k || pq.peek()[0] *1.0 / pq.peek()[1] > t){
                 if(pq.size() == k)
                   pq.poll();
                   pq.add(new int[]{arr[i],arr[j]});
               }
           }

       }


        return pq.poll();
    }
}
