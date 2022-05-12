package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: zms
 * @create: 2022/1/21 22:45
 */
class Solution {
    private int [] nums ;
    private List<List<Integer>> res;
    public Solution(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
         dfs(0,nums,new boolean[nums.length],new ArrayList<>());
         for(int i = 0;i<res.size();i++){
             System.out.println(Arrays.toString(res.get(i).toArray()));
         }
    }

    private void dfs(int start, int[] nums,boolean visited[], ArrayList<Integer> path) {
        if(path.size()== nums.length){
            System.out.println(Arrays.toString(path.toArray()));
            ArrayList tem = new ArrayList();
            tem.addAll(path);
            res.add(tem);
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(visited[i])continue;
            visited[i] = true;
            path.add(nums[i]);
            dfs(0,nums,visited,path);
            path.remove(path.size()-1);
            visited[i] = false;
        }

    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int len = res.size();
        Random r = new Random();

        int num = r.nextInt(len);

        return res.get(num).stream().mapToInt(Integer::valueOf).toArray();
    }


}
public class main384 {
    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        Solution s = new Solution(a);

    }

}
