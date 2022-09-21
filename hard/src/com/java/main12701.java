package com.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/9/4 11:39
 */
public class main12701 {
    public static void main(String[] args) {
        //System.out.println(ladderLength("a", "c", Arrays.asList(new String[]{"a", "b", "c"})));
        //  System.out.println(ladderLength("abcd", "bcdd", Arrays.asList(new String[]{"ebcd", "eccd", "ecdd", "bcdd", "ebcg", "abdd", "bbdd"})));

        System.out.println(ladderLength("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));

    }

    private static boolean check(String beginWord, String s) {
        int countdiff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (beginWord.charAt(i) != s.charAt(i)) countdiff++;
        }
        return countdiff <= 1;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        if (!wordList.contains(endWord)) return 0;
        boolean vis[] = new boolean[wordList.size()];
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String poll = queue.poll();
                if (poll == endWord) return level;
                size--;
                for (int i = 0; i < wordList.size(); i++) {
                    if (!vis[i] && check(poll, wordList.get(i))) {
                        queue.add(wordList.get(i));
                        vis[i] = true;
                    }
                }
            }
            level++;

        }
        return 0;
    }
}
