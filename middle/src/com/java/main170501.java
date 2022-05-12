package com.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2021/12/24 11:43
 */
public class main170501 {
    public static int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int []> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = apples.length,day = 0,ans = 0;
        while(!priorityQueue.isEmpty() || day<n){
            if (day <n && apples[day] >0 ){
                System.out.println(n);
                priorityQueue.add(new int []{day + days[day] -1 , apples[day]});
            }


            while(!priorityQueue.isEmpty() && priorityQueue.peek()[0] < day){
                priorityQueue.poll();
            }
            if(!priorityQueue.isEmpty()){
                int cur[] = priorityQueue.poll();
                if (cur[1] > 1){
                    cur[1] -=1;
                    priorityQueue.add(cur);
                }
                ans ++;
            }
            day++;
        }

    return ans;
    }

    public static void main(String[] args) {
        System.out.println(eatenApples(new int[]{2, 1, 1, 4, 5}, new int[]{10, 10, 6, 4, 2}));
    }
}
