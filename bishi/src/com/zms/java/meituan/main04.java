package com.zms.java.meituan;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/12 16:44
 */
public class main04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        int dp[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            dp[i][i] = arr[i] == 1? 1:0;
        }
//        for(int i = 0;i<n;i++){
//            for(){
//
//            }
//        }




    }

}
