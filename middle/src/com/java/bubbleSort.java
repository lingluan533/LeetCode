package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/3/15 17:23
 */
public class bubbleSort {

    public static void main(String[] args) {
        int a [] = new int[]{174,45,20,1,33,55,999,142,0};
        int n = a.length;
        for (int i = 0;i<n;i++){
            for(int j  = 0;j< n - i - 1 ;j++){
               if(a[j] >a[j+1]){
                   int temp = a[j];
                   a[j] = a[j+1];
                   a[j+1] = temp;
               }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
