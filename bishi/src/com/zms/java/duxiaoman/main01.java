package com.zms.java.duxiaoman;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/31 18:46
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int  k = scan.nextInt();
        int ary [] = new int[n];
        for (int i =0;i<n;i++){
            ary[i] = scan.nextInt();
        }
        int count = 0;
        for (int i = 0;i<n;i++){
            int max = ary[i],min = ary[i];
            for (int j = i;j<n;j++){
                System.out.println(i+"**"+j);
                max = Math.max(max,ary[j]);
                min = Math.min(min,ary[j]);
                if (min*k == max) count ++;
            }

        }
        System.out.println(count);
    }
}
