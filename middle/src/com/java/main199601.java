package com.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: zms
 * @create: 2022/1/28 23:09
 */
public class main199601 {
    public static void main(String[] args) {
        int a [][] = new int[3][2];
        a[0] = new int[]{9,10};
        a[1] = new int[]{9,6};
        a[2] = new int[]{4,3};
        numberOfWeakCharacters(a);
    }
    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, ((o1, o2) -> o1[0] != o2[0] ? o2[0]-o1[0] : o1[1]-o2[1]));
        int count = 0;
        int max = properties[0][1];
        for(int i = 1;i< properties.length;i++){
            if(max > properties[i][1] ) count++;
            max = Math.max(properties[i][1],max);
        }
        return count;
    }
    public static int numberOfWeakCharacters1(int[][] properties) {
        Arrays.sort(properties, ((o1, o2) -> o1[0] != o2[0] ? o1[0]-o2[0] : o2[1]-o1[1]));
        int count = 0;
        int max = properties[properties.length-1][1];
        for(int i = properties.length - 2;i>=0;i--){
            if(max > properties[i][1] ) count++;
            max = Math.max(properties[i][1],max);
        }
        return count;
    }

}
