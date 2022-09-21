package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/8/30 16:40
 */
public class main14002 {
    public static void main(String[] args) {
        //"pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
        List<String> list = new ArrayList<>();
       String  a[] = new String[]{"apple","pen","applepen","pine","pineapple"};
        wordBreak("pineapplepenapple", Arrays.asList(a)).stream().forEach(System.out::println);
    }
    static List<String> res ;
    static String s;
    static List<String> words;
    static int len;
    public static List<String> wordBreak(String ss, List<String> wordDict) {
        res = new ArrayList<>();
        s = ss;
        words = wordDict;
        len = s.length();
        dfs(new StringBuilder(),0);
        return res;
    }

    private static void dfs(StringBuilder path, int start) {
        if (start == len){
            res.add(path.deleteCharAt(path.length()-1).toString());
        }

        for (int i = start+1;i<=len;i++){
            if (words.contains(s.substring(start,i))){
                int lenPath = path.length();
                path.append(s.substring(start,i)+" ");
                dfs(path,i);
                path.delete(lenPath,path.length());
            }
        }
    }
}
