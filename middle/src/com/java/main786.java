package com.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/1/15 13:39
 */
public class main786 {

    public static void main(String[] args) {
        kthSmallestPrimeFraction(new  int[]{1,2,3,5},3);
    }
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int []> pq  = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

               // return Double.compare(o1[0]*1.0/o1[1],o2[0]*1.0/o2[1]);
                return o1[0]*1.0/o1[1]>o2[0]*1.0/o2[1] ? 1 : -1 ;
            }
        });
        for(int i= 0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                if(i==j) continue;
                pq.add(new int[]{arr[i],arr[j]});
            }
        }

        while(k>0 && !pq.isEmpty()){

            if(k == 1) return pq.poll();
            pq.poll();
            k--;
        }
        return null;
    }
}
