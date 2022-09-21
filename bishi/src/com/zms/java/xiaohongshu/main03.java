package com.zms.java.xiaohongshu;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/28 17:07
 */
public class main03 {
    static boolean freiends[][];

   static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
        int ary[] = new int[n-1];
        freiends = new boolean[n+1][n+1];
       for (int i = 0;i<n-1;i++){
           ary[i] = scanner.nextInt();
           freiends[i+2][ary[i]] = true;
           freiends[ary[i]][i+2] = true;
       }
       for (int i = 1;i<=n;i++){
           boolean left[] = new boolean[1000];
           left[i] = true;
           countPair(left,0,1);
       }
        System.out.println(max);
    }
    static  int max = Integer.MIN_VALUE;
    private static void  countPair(boolean left[],int pair,int start) {
        max = Integer.max(max,pair);
        for (int i = 1;i<=n;i++){
            if (!left[i]){
                start = i;
                break;
            }
        }
        if (start > n) {
            max = Integer.max(max,pair);
            return  ;
        }

        for (int i = 1 ;i<=n;i++){
            if (!left[i]&& freiends[start][i]){
                left[i] = left[start] = true;
                pair += 1;
                max = Integer.max(max,pair);
                countPair(left,pair,start+1);
                pair-=1;
                left[i] = left[start] = false;
            }
        }
        max = Integer.max(max,pair);
        return ;
    }
}
