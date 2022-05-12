package com.zms.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zms
 * @create: 2022/2/15 19:23
 */
public class main57 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i  = 0;i< nums.length;i++){
            if(nums[i]<target){
                set.add(nums[i]);
            }else break;
        }
        for(int i =0;i<set.size();i++){
            if(set.contains(target-nums[i])){
                return new int[]{nums[i],target-nums[i]};
            }
        }
        return null;
    }
}
