package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/4/22 15:04
 */
public class main4001 {
    List<List<Integer>> res ;
    //Set<List<Integer>> set;
    Integer [] candidate ;
    int len ;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidate = new Integer[candidates.length];
        this.len = candidates.length;
        this.target = target;
     //   this.set = new HashSet<>();
        for(int i = 0;i<candidates.length;i++){
            candidate[i] = candidates[i];
        }
        this.res = new ArrayList<>();
        Arrays.sort(candidate);
        dfs(0,0,new ArrayDeque<Integer>());
        return res;
    }

    private void dfs(int start, int sum, ArrayDeque<Integer> path) {
        if(sum == target){
            res.add(new ArrayList<>(path));
            return ;
        }
        if(sum > target) return;
        if(start == len){
            return ;
        }
        for(int i = start;i<len;i++){
            if(sum + candidate[i] > target) break;
            if(i>start && candidate[i] == candidate[i-1]) continue;
            path.add(candidate[i]);
            sum += candidate[i];
            dfs(i+1, sum, path);
            sum -= candidate[i];
            path.removeLast();
        }
    }
}
