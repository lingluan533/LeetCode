package com.zms.java;

/**
 * @author: zms
 * @create: 2022/3/14 11:47
 */
public class MergeSort {
    public static void main(String[] args) {
        sortArray(new int[]{49,38,65,97,76,13,27});
    }
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    public static void mergeSort(int []nums,int left,int right,int[]temp){
        if(left < right){
            int mid = (left + right) >>>1;
            mergeSort(nums,left,mid,temp);
            mergeSort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp); //最后再合并起来  这时候左边有序 且右边有序了
        }
    }

    private static void merge(int[] nums, int left, int mid, int right,int[]temp) {
        //d arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
        System.arraycopy(nums,left,temp,left,right - left + 1 );
        int i = left;
        int j = mid + 1;
        for(int k = left;k<=right;k++){
            if(i==mid +1 ){
                nums[k] = temp[j];
                j++;
            }else if(j == right +1){
                nums[k] = temp[i];
                i++;
            }else if(temp[i]<temp[j]){
                nums[k] = temp[i];
                i++;
            }else{
                nums[k] = temp[j];
                j++;
            }
        }

    }

}
