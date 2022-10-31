package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/10/17 16:16
 */
public class main82001 {
    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"p", "grah", "qwosp"}));
    }

    static class Trie {

        Trie child[];

        public Trie() {
            this.child = new Trie[26];
        }

        public int insert(String s) {
            Trie cur = this;
            boolean isEnd = false;
            char cs[] = s.toCharArray();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (cur.child[cs[i] - 'a'] == null) {
                    //是新单词
                    isEnd = true;
                    cur.child[cs[i] - 'a'] = new Trie();
                }
                cur = cur.child[cs[i] - 'a']; // 遍历下一个节点
            }
            return isEnd ? s.length() + 1 : 0;
        }
    }


    public static int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < words.length; i++) {
            len += trie.insert(words[i]);
        }
        return len;
    }
}
