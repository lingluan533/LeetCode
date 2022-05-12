package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/4 9:47
 */
public class main18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i<len - 3 ;i++){
            if(i>0 && nums[i]==nums[i-1]) continue; //如果i的值与上一个i的值相同，那么可以跳过这个i了，去重
            for(int j = i+1;j<len - 2 ;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue; //关键，确保如果存在222的情况时，i，j只枚举前两个2,当j到第三个二的时候会跳过，实现去重
                int k = j + 1 ;
                int l = len - 1;
                while(k<l){
                    if(nums[i] + nums[j] + nums[k] + nums[l] - target == 0){
                        res.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k],nums[l]}));
                        while (k<l && nums[k] == nums[++k]);
                        while (k<l && nums[l] == nums[--l]);
                    }else if(nums[i] + nums[j] + nums[k] + nums[l] - target > 0){  //大于0 说明和太大了 应该缩小
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
