package com.java;

/**
 * @author: zms
 * @create: 2021/12/22 20:29
 */
public class main28 {
    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)   aaabbab
    public int strStr(String ss, String pp) {
        char cs [] = ss.toCharArray();
        char cp [] = pp.toCharArray();
        int m = cs.length;
        int n = cp.length;
        int next[] = new int[n+1];
        next[0] = -1;
        //初始化next数组
        for(int i=0,j=-1;i<n;){
               if(j==-1 || cp[i] == cp[j]){
                   ++i;
                   ++j;
                   next[i] = j;
               }else{
                   j = next[j];
               }
        }

        for(int i = 1,j=0;i<m;i++){
            while(j>0 && cs[i] != cp[j+1]) j = next[j];
            if(cs[i] == cp[j+1]) j++;

            if(j==n) return i-n;
        }
        return -1;
    }
}