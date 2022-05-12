package com.java;

import java.util.*;

/**.
 * 90.子集 II  使用set进行去重  简单易行
 * @author: zms
 * @create: 2022/4/9 10:45
 */
public class main90 {
    List<List<Integer>> res ;
    int nums[];
    Set<List<Integer>>  set;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    this.res = new ArrayList<>();
    this.nums = nums;
    this.set = new HashSet<>();
        Arrays.sort(nums);

        dfs(0,new ArrayList<Integer>());
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            res.add(iterator.next());
        }
        return  res;
    }

    private void dfs(int start, ArrayList<Integer> path) {


            set.add(new ArrayList<>(path));


        for(int i = start;i< nums.length;i++){
            path.add(nums[i]);
            dfs(i+1,path);
            path.remove(path.size() - 1 );
        }
    }
}
