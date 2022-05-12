package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/18 9:48
 */
public class main38601 {
    public static void main(String[] args) {
        lexicalOrder(13);
    }
    static int n = 0;
    public static List<Integer>   lexicalOrder(int _n) {
        n = _n;
        List<Integer> res = new ArrayList<>();

        dfs(res,0);
        res.remove(0);
        return res;
    }

    private static void dfs(List<Integer> res, int start) {
        if(start > n) return ;

        for(int i=0; i<10 && (start + i) < n;i++){
            res.add(start + i);
            dfs(res,(start + i )* 10);
        }
    }
}
