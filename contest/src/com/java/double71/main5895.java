package com.java.double71;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author: zms
 * @create: 2022/2/5 22:46
 */
public class main5895 {
    public static void main(String[] args) {
        //pivotArray(new int[]{4,0,4,5,-11},5);
        pivotArray(new int[]{9,12,5,10,14,3,10},10);
    }
    public static int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int count = 0;
        for(int i = 0;i< nums.length;i++){
            if(nums[i]<pivot){
                list1.add(nums[i]);
            }else if(nums[i] > pivot){
                list2.add(nums[i]);
            }else{
                count++;
            }
        }
        int i = 0;
        for(;i< list1.size();i++){
            nums[i] = list1.get(i);
        }
        for(;count>0;count--){
            nums[i++] = pivot;
        }

        for(int j = 0;j<list2.size();j++){
            nums[i++] = list2.get(j);
        }
        return nums;
    }
}
