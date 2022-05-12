package com.java;

/**
 * @author: zms
 * @create: 2022/1/19 9:43
 */
public class main219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for(int i = 0;i<len  ;i++){
            for(int j = i+1 ;j< len&& j<= i+k;j++){
                if(nums[i] == nums[j] ){
                    return true;
                }
            }
        }
        for(int i = 0;i<len - k ;i++){
            for(int j = i+1 ;j<= i+k;j++){
                if(nums[i] == nums[j] ){
                    return true;
                }
            }
        }
        return false;
    }
}
