package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/18 9:09
 */
public class main13901 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak("leetcode",list);
    }
    public static  boolean wordBreak(String s, List<String> wordDict) {
       int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        for(int i = 1;i<n+1;i++){
            for(int j = 0 ; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
