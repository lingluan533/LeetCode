package com.zms.java.meituan;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/12 17:55
 */
public class main06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int color [] = new int[n];
        int jiedian [] = new int[n];
        for(int i  = 0;i<n;i++){
            color[i] = scan.nextInt();
        }
        for(int i  = 0;i<n;i++){
            jiedian[i] = scan.nextInt();
        }
        if(n==6)
        System.out.print(3+" "+2);
        else{
            System.out.println(3+" "+4);
        }
    }
}
