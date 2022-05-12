package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/4/6 19:53
 */
public class main3902 {
    List<List<Integer>> res ;
    int candida[];

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         this.candida = candidates;
         this.res = new ArrayList<>();
        Arrays.sort(candida);
         dfs(new ArrayList<Integer>(),target,0);
         return res;
    }

    private void dfs(ArrayList<Integer> list,int target,int start) {
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0) return;
        for(int i = start;i< candida.length;i++){
            list.add(candida[i]);
            target -= candida[i];
            dfs(list,target,i); //去重的关键：使得下一次还可以取这次取的元素，保证了元素可以重复使用
                                //            使得选取的元素不会在start的之前，保证了结果的不重复
            target+=candida[i];
            list.remove(list.size()-1);
        }
    }
}
