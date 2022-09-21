package com.zms.java.zijie;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/28 9:50
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int ary [] = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<N;i++){
            list.add(scan.nextInt());
        }
        long max = Long.MIN_VALUE;
        for (int i = 0;i<N;i++){
            ArrayList<Integer> list1 = new ArrayList(list);
            list1.remove(i);
           max = Math.max( getMaxK(list1,K),max);
        }
        System.out.println(max);



    }

    private static long getMaxK(ArrayList<Integer> list1, int k) {
        long max = 0;
        for (int i = 0;i<=list1.size()-k;i++){
            long sum = 0;
            for (int j = i;j<i+k;j++){
                sum+=list1.get(j);
            }
            max = Math.max(max,sum);
        }
       return max;
    }
}
