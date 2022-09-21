package com.zms.java.xiecheng;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/30 20:31
 */
public class main04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q= scan.nextInt();
        int[] ary = new int[q];
        for(int i =0;i<q;i++){
            ary[i] = scan.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int second = max +2;
        int len = ary.length;
        int f =0,m = 0,l =0,p = 0;
        for (int i = 1;i<len;i++){
            if (Math.abs(ary[i]-ary[i-1])>max){
                f = i-2;
                m = i-1;
                l = i;
                p = i+1;
                max = Math.abs(ary[i]-ary[i-1]);
            }else{
                if (Math.abs(ary[i]-ary[i-1])>second){
                    f = i-2;
                    m = i-1;
                    l = i;
                    p = i+1;
                    second = Math.abs(ary[i]-ary[i-1]);
                }
            }
        }
        System.out.println(second);

    }
}
