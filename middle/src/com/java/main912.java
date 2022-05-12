package com.java;

/**
 * @author: zms
 * @create: 2022/3/8 22:48
 */
public class main912 {
    public static void main(String[] args) {
        sortArray(new int[]{41,52,1,4,65,78,100,41,20});
    }
    public static int[] sortArray(int[] nums) {

        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private  static void quickSort(int[] nums, int low, int high) {

        int i = low,j = high;
        if(low < high){
            int temp = nums[low];
            while(i<j){
                while(i<j && nums[j]>=temp) j--;
                if(i<j){
                    nums[i] = nums[j];
                    i++;
                }

                while(i<j && nums[i]<temp) i++;
                if(i<j){
                    nums[j] = nums[i];
                    j--;
                }

            }

            nums[i] = temp;
            quickSort(nums,low,i-1);
            quickSort(nums,i+1,high);
        }

    }


}
