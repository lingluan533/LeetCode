package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/10/30 17:52
 */
public class main17_18 {
    public int[] shortestSeq(int[] big, int[] small) {
        int lenbig = big.length;
        int lensmall = small.length;
        HashMap<Integer, Integer> map = new HashMap(); // 正数表示需求量 负数表示区间内多的数
        for (int i = 0; i < lensmall; i++) {
            map.put(small[i], 1);
        }
        int min = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;
        int start = 0;
        int end = 0;
        int need = lensmall;
        while (right < lenbig) {
            int cur = big[right];
            if (!map.containsKey(cur)) {
                right++;
                continue;
            }
            if (map.get(cur) > 0) {
                need--;
                map.put(cur, map.get(cur) - 1);
            } else {
                map.put(cur, map.get(cur) - 1);
            }
            while (need == 0) {
                int leftval = big[left];
                if (!map.containsKey(leftval)) {
                    left++;
                    continue;
                }
                if (map.get(leftval) == 0) {
                    if (right - left + 1 < min) { // 计算最新的长度
                        start = left;
                        end = right;
                        min = right - left + 1;
                        map.put(leftval, 1);
                        left++;
                        need++;
                    }
                    break;
                } else if (map.get(leftval) < 0) {
                    map.put(leftval, map.get(leftval) + 1);
                    left++;
                }
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? new int[]{} : new int[]{start, end};
    }
}
