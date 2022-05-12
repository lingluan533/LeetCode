package com.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/22 16:26
 */
public class main216 {
    List<List<Integer>> res ;
    int k , n ;
    int candadites[];
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.res = new ArrayList<>();
        this.k = k;
        this.n = n;
        int sum = 0;
        for(int i = 1 ;i<=k;i++){
            sum += i;
        }
        if(sum > n){
            return res;
        }
        this.candadites = new int[10];
        for(int i  = 1;i<=9;i++){
            candadites[i] = i;
        }
        dfs(1,new ArrayDeque<Integer>(),0);
        return res;
    }

    private void dfs(int start, ArrayDeque<Integer> path, int sum) {
        if(sum == n){
            if(path.size()==k){
                res.add(new ArrayList<>(path));
                return;
            }else{
                return;
            }
        }
        if(start == 10) return;
        for(int i = start;i<10;i++){
            sum += i;
            path.add(i);
            dfs(i+1,path,sum);
            sum -= i;
            path.removeLast();
        }
    }
}
