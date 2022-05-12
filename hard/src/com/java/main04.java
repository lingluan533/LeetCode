package com.java;

/**
 * @author: zms
 * @create: 2022/3/30 21:37
 */
public class main04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2 ;
        int right = (m + n + 2) / 2;
        return (getMinK(nums1,0,m-1,left,nums2,0,n-1) + getMinK(nums1,0,m-1,right,nums2,0,n-1)) * 0.5;
    }

    private double  getMinK(int[] nums1, int start1, int end1, int k, int[] nums2, int start2, int end2) {
            int len1 = end1 - start1 + 1 ;
            int len2 = end2 - start2 + 1 ;
            if(len1 == 0 ) return nums2[start2 + k - 1];
            if(len2 == 0 ) return  nums1[start1 + k - 1];
            if(k==1) return Math.min(nums1[start1], nums2[start2]);

            int i = start1 + Math.min(len1,k /2) - 1;
            int j = start2 + Math.min(len2,k / 2) - 1;
            if(nums1[i] < nums2[j]){ //抛弃nums1前面的元素
                return getMinK(nums1,i+1,end1,k - (i-start1+1),nums2,start2,end2);
            }else{
                return getMinK(nums1, start1, end1, k - (j-start2+1), nums2, j+1, end2);
            }
    }
}
