package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/4/7 11:24
 */
public class jianzhi66 {
    public static void main(String[] args) {

    }
    public int[] constructArr(int[] a) {
        int len = a.length;
        int L[] = new int[len];
        int R[] = new int[len];
        L[0] = 1;
        R [len-1] = 1;
        for(int i = 1;i<len;i++){
            L[i] = a[i-1] * L[i-1];
        }
        for(int j = len-2;j>=0;j--){
            R[j] = a[j+1] * R[j+1];
        }
        int b[] = new int[len];
        for(int i = 0;i<len;i++){
            b[i] = L[i]  * R[i];
        }

        return b;


    }
}
