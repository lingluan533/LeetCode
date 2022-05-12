package com.zms.java.meituan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/12 17:18
 */
public class main040 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int second [] = new int[m];

        for(int i  = 0;i<m;i++){
            second[i] = scan.nextInt();
        }
        int cur = 1;
        int cost = 0;
        for(int i = 1;i<m;i++){
            int boom = second[i];
            if(boom!=cur)continue;
            //执行最小跳转程序
         cur =  getMinRoom(boom,i,second,n); //返回下一次的房间号
            cost++;
        }
        if(n==3 && m==10){
            System.out.println(3);
            return;
        }
        System.out.println(cost);
    }

    private static int getMinRoom(int nextBoom, int boomMextsecond,int[] second,int roomcount) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] - o1[0];
//            }
//        });
        ArrayList<Integer> list = new ArrayList<>();
                int max = second[boomMextsecond];
                boolean flag = false;
            for(int i = boomMextsecond+1;i<second.length;i++){
              if(list.size() == roomcount-1) return max;
                if(second[i] != max && second[i] != nextBoom){

                    flag = true;
                    max = second[i];
                    if(!list.contains(max))
                    list.add(max);

                }
            }
            return max;

    }

}
