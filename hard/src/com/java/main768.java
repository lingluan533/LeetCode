package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/8/13 11:58
 */
public class main768 {
    public static void main(String[] args) {
        maxChunksToSorted(new int[]{4,2,2,1,1});
    }
    public static int maxChunksToSorted(int[] arr) {
       int len = arr.length;
       int group = 1;
       int rightMin[] = new int[len];
       rightMin[len-1] = arr[len-1];
       for(int i = len-2;i>=0;i--){
           rightMin[i] = Math.min(arr[i],rightMin[i+1]);
       }
       int leftMax = arr[0];
       for(int i=0;i<len;i++){
           if(leftMax<=rightMin[i]){
               group ++;
           }
           leftMax = Math.max(leftMax,arr[i]);
       }
       return group ;
    }
}

