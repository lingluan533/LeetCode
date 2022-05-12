package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/4 10:20
 */
public class main4701 {
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
        HashSet<String> set = new HashSet();
        dfs(new boolean[len],nums,new ArrayList<Integer>(),list,set);
        return list;
    }

    private static void dfs(boolean[] vis, int[] nums, ArrayList<Integer> list,  List<List<Integer>>  res,  HashSet<String> set) {
            if(list.size() == nums.length){
                if(!set.contains(Arrays.toString(list.toArray()))){
                    set.add(Arrays.toString(list.toArray()));
                    //System.out.println(list.toArray().toString());
                    res.add(new ArrayList<>(list));
                }
                return;
            }

            for(int i = 0;i< nums.length;i++){
                if(vis[i])continue;
               // if(!vis[i] && i>0 && nums[i]==nums[i-1])continue;
                vis[i] = true;
                list.add(nums[i]);
                dfs(vis, nums, list, res,set);
                list.remove(list.size()-1);
                vis[i] = false;
            }
    }
}
