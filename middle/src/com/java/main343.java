package com.java;

/**
 * @author: zms
 * @create: 2022/3/9 13:49
 */
public class main343 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    public int integerBreak(int n) {

        int res = 1;
        if(n==2) return 2;
        if(n==3) return 3;

        while(n>=5){
            res *= 3;
            n-=3;
        }
        if(n==2) return res*=2;
        if(n==3) return res*=3;
        if(n==4) return res*=4;
        return 0;
    }
}
