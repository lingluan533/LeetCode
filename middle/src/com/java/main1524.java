package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/8/26 23:59
 */
public class main1524 {
    public static void main(String[] args) {
        int a = (10^9+7);
        int b = 1000000007;
        System.out.println((10^9+7)==1000000007);
        System.out.println(numOfSubarrays(new int[]{1, 3, 5}));
    }
    public static int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int odd = 0, even = 1;
        int res = 0;
        int sum = 0;
        int len = arr.length;
        for (int i = 0;i<len;i++){
            sum += arr[i];
            res = (res + (sum %2==0? odd : even)) % MOD;
            if (sum%2==0){
                even++;
            }else odd++;
        }
        return res;
    }
}
