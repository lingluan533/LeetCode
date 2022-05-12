package com.java;

/**
 * @author: zms
 * @create: 2022/4/20 17:48
 */
public class main96 {
    public int numTrees(int n) {
        if(n == 1) return 1;
        if (n==2) return 2;
        if(n==3) return 5;
        int arr[] = new int[20];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        for(int i = 4;i <= n;i++){
            int sum =0;
            for(int j = 2;j<i;j++){
                sum += arr[j-1] * arr[i - j];
            }
            sum += 2* arr[i - 1];
            arr[i] = sum;
        }
        return arr[n];
    }
}
