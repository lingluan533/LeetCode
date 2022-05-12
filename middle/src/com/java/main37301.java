package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/15 12:09
 */
public class main37301 {
    public static void main(String[] args) {
        kSmallestPairs2(new int[]{1,1,2},new int[]{1,2,3},2);
    }
    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int left = nums1[0] + nums2[0];
        int right = nums1[m-1] + nums2[n-1];
        if(k >= m*n){
            for(int i = 0;i<m;i++){
                for(int j = 0; j< n;j++){
                    res.add(Arrays.asList(nums1[i],nums2[j]));
                }
            }
            return res;
        }
        //最终找到第一个值，该分界值使得前面有大于等于k个数对和 小于等于该分界值
        //找到第一个满足「点对和小于等于 x 的，且数量超过 k 的值 x」。
        while(left < right){
            int mid = left + (right - left) /2; //mid为本次的分界值
            int start = 0;
            int end = n-1;
            int count = 0;
            // 双指针查找当前比 mid 小的元素个数，用来确定二分的方向
            while(start < m && end >=0 ){
                if(count >=k) break;//剪枝
                if(nums1[start] + nums2[end] >  mid){
                    end --;
                }else{
                    count += end+1;
                    start++;
                }
            }
            if(count < k ){
                left = mid + 1 ;

            }else {
                right = mid ;
            }
        }
       // 当二分出第 k 小的值为 x 后，由于存在不同点对的点对和值相等，我们需要先将所有点对和小于等于 x 的值加入答案，然后酌情把值等于 x 的点对加入答案，知道满足答案数量为 k。
        int divideNum = left;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if( res.size() < k && nums1[i] + nums2[j] < divideNum){
                    res.add(Arrays.asList(nums1[i],nums2[j]) );
                }else break;
            }
        }
        // 找到等于分界点的值的数对
        int index = n - 1;
        for(int i = 0;i<m && res.size() < k ;i++){
            // 找到第一个不大于分界点值的数对
            while(index >= 0 && nums1[i] + nums2[index] > divideNum){
                index--;
            }
            for (int j = i; j >= 0; j--) {
                if( res.size() < k && nums1[j] + nums2[index] == divideNum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[j]);
                    list.add(nums2[index]);
                    res.add(list);

                }else break;
            }
        }


return res;
    }
}
