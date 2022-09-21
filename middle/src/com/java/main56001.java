package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/8/26 17:48
 */
public class main56001 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer,Integer> preSumMap = new HashMap<>();
        preSumMap.put(0,1);
        int sum = 0;
        int res = 0;
        for (int i = 0;i<len;i++){
            sum+=nums[i];
            if (preSumMap.containsKey(sum - k )){
                res += preSumMap.get(sum-k);
            }
            preSumMap.put(sum, preSumMap.getOrDefault(sum ,0)+1);
        }
        return res;
    }
}
