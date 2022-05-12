package com.java;

import java.util.*;

/**
 * 90.子集 II  利用同一树层不选择 相同元素来进行去重
 * @author: zms
 * @create: 2022/4/9 10:45
 */
public class main9001 {
    List<List<Integer>> res ;
    int nums[];

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        Arrays.sort(nums);
        dfs(0,new ArrayList<Integer>(),new boolean[nums.length]);
        return  res;
    }

    private void dfs(int start, ArrayList<Integer> path,boolean vis[]) {

        res.add(new ArrayList<>(path));
        for(int i = start;i< nums.length;i++){
            if(i > 0 && nums[i-1] == nums[i] && !vis[i - 1]) continue;
            path.add(nums[i]);
            vis[i] = true;
            dfs(i+1,path,vis);
            vis[i] = false;
            path.remove(path.size() - 1 );
        }
    }
}
