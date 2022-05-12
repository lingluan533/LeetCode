package com.zms.java.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/12 15:59
 */
public class main022 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        int count = 0;
     for(int i =0;i<n;i++){
         int curval = arr[i];
         for(int j = i;j<n;j++){
             if(j==i){
                 if(arr[j] ==1) {
                     count++;

                 }
                 continue;
             }
             if(curval*arr[j] == 1){
                 count++;
             }
           curval = curval*arr[j];
         }
     }
        System.out.println(count);
    }


}
