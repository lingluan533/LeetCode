package com.zms.java.bzhan;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/1 19:46
 */
public class main01 {
    public static boolean isP(long n,boolean p[]){

            if (p[(int) n]) return false;

        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        if (n==2 || n==3||n==5||n==7) {
            System.out.println(n);
            return;
        }
        long res = 0;
        boolean isPar[] =  new boolean[Integer.MAX_VALUE];  //默认都是素数
        isPar[2] = true;
        isPar[3] = true;
        for (long i = 2;i<Math.sqrt(n);i++ ){
            if (isPar[(int) i]){
                for (long j = 2;j * i<n;j++ ){
                    isPar[(int) (j*i)] = true;
                }
            }

        }
        isPar[2] = false;
        isPar[3] = false;
        while (n!=1){
            for (int i = 2;i<Math.sqrt(n);i++){
                while (n%i==0){
                    n/=i;
                    res += i;
                    if (n==1){
                        System.out.println(res);
                        return;
                    }
                }if(isP(n,isPar)){
                    res += n;
                    System.out.println(res);
                    return;
                }

            }
        }


    }
}
