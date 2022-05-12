package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/4 10:20
 */
public class main4702 {
    public static void main(String[] args) {
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        for (int i= 0;i<lists.size();i++){
            for (int j = 0;j<lists.get(i).size();j++){
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list  = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        dfs(new boolean[len],nums,new ArrayList<Integer>(),list);
        return list;
    }

    private static void dfs(boolean[] vis, int[] nums, ArrayList<Integer> list,  List<List<Integer>>  res) {
        if(list.size() == nums.length){
                res.add(new ArrayList<>(list));

            return;
        }

        for(int i = 0;i< nums.length;i++){
            if(vis[i])continue;
             if(i>0 && !vis[i-1] && nums[i]==nums[i-1])continue;
            vis[i] = true;
            list.add(nums[i]);
            dfs(vis, nums, list, res);
            list.remove(list.size()-1);
            vis[i] = false;
        }
    }
}
