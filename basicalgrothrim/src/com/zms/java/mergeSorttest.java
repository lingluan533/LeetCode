package com.zms.java;

/**
 * @author: zms
 * @create: 2022/3/24 11:09
 */
public class mergeSorttest {

    public int[] mergeSoret(int nums[]){

        return mergeSortMethod(nums,0,nums.length - 1 ,new int[nums.length]);
    }

    private int[] mergeSortMethod(int[] nums, int left, int right, int[] temp) {
        if (left < right){
            int mid = left + (right - left)/2;
            mergeSortMethod(nums,left,mid,temp);
            mergeSortMethod(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
        return nums;
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums,left,temp,left,right - left + 1 );

        int i = left;
        int j = mid + 1 ;

        for(int k = i;k <=right;k++){
            if(i>mid){
                nums[k] = temp[j++];

            }else if(j>right){
                nums[k] = temp[i++];
            }else if(temp[i] >= temp[j]){
                nums[k] = temp[j++];
            }else if(temp[i]<temp[j]){
                nums[k] = temp[i++];
            }
        }


    }
}
