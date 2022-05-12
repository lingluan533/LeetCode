package com.java;

/**
 * @author: zms
 * @create: 2022/4/28 9:28
 */
public class main905 {

    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int count = 0; //偶数计数
        for(int i = 0; i < len ;i++){
            if(nums[i]%2==0) count++;
        }
        if (len == 1) return nums;
        int i = 0, j = len - 1;
        while (i < count && i < j){
            while (i<j && nums[i]%2==0){
                i++;
            }
            while (i<j && nums[j] % 2 !=0){
                j--;
            }
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }
        return nums;
    }
}
