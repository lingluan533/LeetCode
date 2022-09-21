package com.zms.java.amzon;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/8/20 10:17
 */
public class main02 {
    public static void main(String[] args) {
        getMaxAggregateTemperatureChange(Arrays.asList(new Integer[]{-1,2,3}));
    }
    public static long getMaxAggregateTemperatureChange(List<Integer> tempChange) {
        long max = Long.MIN_VALUE;
        int len = tempChange.size();
        long suma[] = new long[len];
        long sumb[] = new long[len];
        suma[0] = tempChange.get(0);
        sumb[len-1] = tempChange.get(tempChange.size()-1);
        for (int i = 1;i<len;i++){
            suma[i] = suma[i-1] + tempChange.get(i);
        }
        for (int i = len-2;i>=0;i--){
            sumb[i] = sumb[i+1] + tempChange.get(i);
        }

        for (int i = 0;i<len;i++){
            long cur = suma[i] + sumb[i];
            max = Long.max(max,cur);
        }
        return max;
    }
}
