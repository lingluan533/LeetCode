package com.java;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/8/13 11:08
 */
public class main769 {
    public static void main(String[] args) {
        maxChunksToSorted(new int[]{1,0,2,3,4});
    }
    public static int maxChunksToSorted(int[] arr) {
        int group = 0;
        int len = arr.length;
        int start = 0,end = 0;
        for (int i = 0;i<arr.length;i++){
            int cur = i;
            while (cur+1<len && arr[cur] > arr[cur+1]){
                cur++;
            }
            if (cur < len ){
                Arrays.sort(arr,i,cur+1);
                group ++;
            }
            i = cur;
        }
            int i = 0;
            while(i+1<len && arr[i]<arr[i+1])i++;


        return i == len-1 ? group :1 ;
    }
}
