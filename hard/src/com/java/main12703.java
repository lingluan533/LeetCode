package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/9/4 17:17
 */
public class main12703 {
    class Solution {

        public boolean check(String beginWord, String s) {
            int countdiff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (beginWord.charAt(i) != s.charAt(i)) countdiff++;
            }
            return countdiff <= 1;
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> hashSet = new HashSet<>(wordList);
            Queue<String> queue = new ArrayDeque<>();
            if (!hashSet.contains(endWord)) return 0;
            queue.add(beginWord);
            int level = 1;
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    String poll = queue.poll();
                    if (poll.equals(endWord)) return level;
                    size--;
                    for (int i = 0; i < wordList.size(); i++) {
                        if (!visited.contains(wordList.get(i)) && check(poll, wordList.get(i))) {
                            queue.add(wordList.get(i));
                            visited.add(wordList.get(i));
                        }
                    }
                }
                level++;

            }
            return 0;
        }
    }
}
