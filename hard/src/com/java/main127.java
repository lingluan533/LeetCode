package com.java;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/9/4 11:07
 */
public class main127 {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }

    static int min = Integer.MAX_VALUE;

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) { // 不存在末尾 直接返回0
            return 0;
        }
        // dfs
        // vis数组 标志已经使用过
        // 回溯修改
        // 变量记录长度
        int len = wordList.size();
        dfs(new boolean[len], wordList, beginWord, endWord, 0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private static void dfs(boolean[] vis, List<String> wordList, String beginWord, String endWord, int len) {
        if (beginWord == endWord) {
            min = Math.min(min, len + 1);
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (vis[i]) continue;
            if (check(beginWord, wordList.get(i))) {
                vis[i] = true;
                len++;
                dfs(vis, wordList, wordList.get(i), endWord, len);
                vis[i] = false;
                len--;
            }
        }
    }

    private static boolean check(String beginWord, String s) {
        int countdiff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (beginWord.charAt(i) != s.charAt(i)) countdiff++;
        }
        return countdiff <= 1;
    }
}
