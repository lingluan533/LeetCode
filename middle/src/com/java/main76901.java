package com.java;

/**
 * @author: zms
 * @create: 2022/8/13 11:48
 */
public class main76901 {
    public int maxChunksToSorted(int[] arr) {
        int group = 0;
        int len = arr.length;
        int indexSum = 0;
        int cursum = 0;
        for(int  i = 0;i<len;i++){
            indexSum += i;
            cursum+=arr[i];
            if (cursum==indexSum){
                indexSum = 0;
                cursum  = 0;
                group++;
            }
        }
        return group;
    }
}
