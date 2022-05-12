package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/20 16:56
 */
public class main4602 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,new boolean[nums.length],res,new ArrayList<>());
        return  res;
    }

    public void dfs(int nums[],boolean vis[],List<List<Integer>> res,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list)); // 切记要新建一个对象 不然存了等于白存
            return;
        }
        for(int i = 0;i< nums.length;i++){
            if(vis[i]) continue;
            vis[i] = true;
            list.add(nums[i] );
            dfs(nums,vis,res,list);
            vis[i] = false;
            list.remove(list.size()-1);
        }

    }
}
