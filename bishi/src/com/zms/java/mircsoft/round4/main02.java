package com.zms.java.mircsoft.round4;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: zms
 * @create: 2022/8/25 19:24
 */
public class main02 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,-2,3,0,4,-7}));
    }
    public static  int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        int len = A.length;
        HashMap<Integer,Integer> pres = new HashMap<>();
        pres.put(0,1);
        int ans = 0,sum = 0;
        for (int i = 0;i<len;i++){
            sum+=A[i];
            if (pres.containsKey(sum)){
                ans += pres.get(sum);
                if (ans>=1000000000) return -1;
            }
            pres.put(sum,pres.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
