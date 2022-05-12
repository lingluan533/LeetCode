package com.java;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/25 11:07
 */
public class main119 {
    public static void main(String[] args) {
        getRow(3);
    }
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) return Arrays.asList(new Integer[]{1});
        if(rowIndex == 1) return Arrays.asList(new Integer[]{1,1});
        Integer last [] = new Integer[]{1,1};
        for(int i = 2;i<=rowIndex;i++){
            Integer cur [] = new Integer[i+1];
            cur[0] = 1;
            cur[i] = 1;
            for(int j = 1;j<i;j++){
                cur[j] = last[j-1] + last[j];
            }
            last = cur;
        }
        return Arrays.asList(last);
    }
}
