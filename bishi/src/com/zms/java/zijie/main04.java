package com.zms.java.zijie;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/28 9:50
 */
public class main04 {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0;i<t;i++){
            int N = scan.nextInt();
            int ary [] = new int[N];
            for (int j = 0;j<N;j++){
                ary[j] = scan.nextInt();
            }
            int mod = 1000000000+7;
            int res[] = new int[2];
            long temp = 1;
            long  max = Long.MIN_VALUE;
            boolean flag = true;
            for (int m = 0;m<N;m++){
                if(ary[m]==0)flag = false;
            }
            if (!flag)   System.out.println((1)+" "+(N));
            for (int k=0;k<ary.length;k++){
                for (int l=k;l<ary.length;l++){


                    temp*=ary[l];
                    temp %= mod;
                    if (temp>max){
                        max = temp;
                        res[0] = k;
                        res[1] = l;
                    }
                }
                temp = 1;
            }
            if (i!=N-1)
            System.out.println((res[0]+1)+" "+(res[1]+1));
            else  System.out.print((res[0]+1)+" "+(res[1]+1));
        }
    }
}
