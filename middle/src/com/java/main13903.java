package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/8/30 15:23
 */
public class main13903 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        String as [] = new String[]{};
        wordBreak("\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaab\"",list);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();

        return   dfs(s,len,0,0,new ArrayList<>(),wordDict);

    }

    private static boolean dfs(String s, int len, int start,int matchLen, ArrayList<Integer> checkedIn,List<String> wordDict)  {
        if (start==len){
            return matchLen == len;
        }

        for (int i = start;i<len;i++){
            String temp = s.substring(start,i+1);
            if (checkedIn.contains(i)) continue;
            if (!wordDict.contains(temp)){  // 当前小区间不能在字典中找到 就尝试下一个可能的位置 小区间
                continue;
            }
            // dfs 下一个位置
           if( dfs(s,len,i+1, matchLen + i+1-start,checkedIn,wordDict)) return true;
           checkedIn.add(i);
        }
        // 在这一层遍历完全串之后 发现还是不能实现完全匹配 就返回false  这一层的false 会被上一层感知 并且添加i到list中 表示0-i已经计算过了
        // 0-i可以匹配 但是i之后的串无法匹配 所以这种以i+1为起点的路径不用再计算了。
        return false;
    }
}
