package com.java;

/**
 * @author: zms
 * @create: 2022/1/25 22:09
 */
public class main1688 {

    public int numberOfMatches(int n) {
        int res = 0;
        while(n!=1){
            if(n%2==0){
                res += n / 2;
                n /= 2;
            }else{
                res += (n-1)/2;
                n = (n-1)/2 + 1;
            }
        }
        return res;
    }
}
