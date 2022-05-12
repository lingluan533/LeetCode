package com.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: zms
 * @create: 2022/1/28 22:26
 */
public class main1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i< properties.length;i++){
            for(int j = i+1;j< properties.length;j++){
                if(properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]){
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();

    }
}
