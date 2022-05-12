package com.zms.java.bianlifeng;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/17 19:03
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Y = scan.nextInt();
        int N = scan.nextInt();
//        int v[] = new int[N];
//        int w[] = new int[];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i = 0;i<N;i++){
            int a [] = new int[2];
            a[0] = scan.nextInt();
            a[1] = scan.nextInt();
            queue.add(a);
        }
        while(Y>0 && !queue.isEmpty()){
            int[] poll = queue.peek();
            int v = poll[0];
            int w = poll[1];
            if(Y - v*w >=0){
                Y -= v*w;
                queue.poll();
                continue;
            }
//            if(Y - v >= 0){         //这里导致超时了，可以直接算出来能放多少个 然后减去就好了
//                Y -= v;
//                queue.poll();
//                poll[1] --;
//                queue.add(poll);
//            }

            Y -= (Y / v)*v;
            queue.poll();
            poll[1] -= Y /v;
            queue.add(poll);
        }

    }
}
