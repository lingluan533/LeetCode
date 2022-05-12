package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/4 10:38
 */
public class main88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0&&n==0) return;
        if(m==0){
            for(int i = 0;i<n;i++){
            nums1[i] = nums2[i];
            }
            return;
        }
        int tempnums1 [] = new int[m];
        for(int i = 0;i<m;i++){
            tempnums1[i] = nums1[i];
        }
        int p = 0;
        int q = 0;
        int count = 0;
        while(p<m && q<n){
            if(tempnums1[p] <= nums2[q]){
                nums1[count++] = tempnums1[p++];
            }else{
                nums1[count++] = nums2[q++];
            }
        }

        if(p<m){
            while(p<m){
                nums1[count++] = tempnums1[p++];
            }
        }
        if(q<n){
            while(q<n){
                nums1[count++] = nums2[q++];
            }
        }

    }
}
