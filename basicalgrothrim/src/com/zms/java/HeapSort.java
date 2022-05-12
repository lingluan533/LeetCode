package com.zms.java;

/**
 * @author: zms
 * @create: 2022/3/22 10:05
 */
public class HeapSort {
    public int[] heapSort(int nums[]){
        int len = nums.length;
        for(int i = ( len - 1 ) / 2 ; i >= 0; i-- ){
            sift(nums,i,len-1);
        }
        int temp ;
        for(int i = len-1;i>=1;i--){
            temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            sift(nums,0,i-1);
        }
        return nums;

    }

    public static void sift(int nums[],int low, int high){
        int i = low;
        int j = 2 * i +1;
        int temp = nums[i] ;
        while (j <= high){
            if( j <= high && nums[j] < nums[j + 1]){
                j++;
            }
            if(temp < nums[j]){
                nums[i] = nums[j];
                i = j;
                j = 2 * i + 1;
            }else{
                break;
            }
        }
        nums[i] = temp; //i无法下移了

    }
}
