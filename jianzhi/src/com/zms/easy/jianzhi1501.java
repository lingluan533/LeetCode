package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/2/24 12:26
 */
public class jianzhi1501 {
    public int hammingWeight(int n) {
       int ans = 0;
        while (n!=0){
            ans += n & 1;
            n= n>>>1;
        }
        return ans;
    }
}
