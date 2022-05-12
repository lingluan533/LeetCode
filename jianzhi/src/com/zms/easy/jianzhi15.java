package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/2/24 12:24
 */
public class jianzhi15 {
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0;i<32;i++){
           ans+=  (n>>i) & 1;

        }
        return ans;
    }

}
