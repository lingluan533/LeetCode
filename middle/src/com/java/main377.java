package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/4/22 19:51
 */
public class main377 {
    Integer candidates[];
    int target;
    int len;
    Set<List<Integer>> res;
    public int combinationSum4(int[] nums, int target) {
        this.len = nums.length;
        this.candidates = new Integer[len];
        Arrays.sort(candidates);
        for(int i = 0;i<len;i++){
            candidates[i] = nums[i];
        }
        this.target = target;

        dfs(0,new ArrayDeque<Integer>());
        return res.size();
    }

    private void dfs( int sum, ArrayDeque<Integer> path) {
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<len;i++){
            if(sum + candidates[i] > target) return;
            sum += candidates[i];
            path.add(candidates[i]);
            dfs(sum,path);
            sum -= candidates[i];
            path.removeLast();

        }
    }
}
