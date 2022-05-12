package com.zms.java.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/20 18:52
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int A[] =new int[n];
        int B[] = new int[n];
        for(int i=0;i<n;i++){
            A[i] = scan.nextInt();
        }
        for(int i = 0;i<n;i++){
            B[i] = scan.nextInt();
        }

        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i =  0;i<n;i++){
            sum += (A[i]*A[i]+B[i]*B[i] - 2*A[i]*B[i]);
        }
        System.out.println(sum);
    }
}
