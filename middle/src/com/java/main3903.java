package com.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/22 21:14
 */
public class main3903 {
    List<List<Integer>> res;
    Integer cadidate[] ;
    int len ;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.cadidate = new Integer[candidates.length];
        this.len = candidates.length;
        for(int i = 0;i<len;i++){
            cadidate[i] = candidates[i];
        }
        this.res  = new ArrayList<>();
        this.target = target;
        dfs(0,0,new ArrayDeque<Integer>());
        return res;
    }

    private void dfs(int start, int sum, ArrayDeque<Integer> path) {
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start;i<len;i++){
            if(sum + cadidate[i] > target) return;
            sum += cadidate[i];
            path.add(cadidate[i]);
            dfs(i,sum,path);
            sum -= cadidate[i];
            path.removeLast();
        }


    }
}
