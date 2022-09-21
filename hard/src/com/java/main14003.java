package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/8/30 17:45
 */
public class main14003 {
    static List<String> res ;
    static String s;
    static List<String> words;
    static int len;
    public static List<String> wordBreak(String ss, List<String> wordDict) {
        res = new ArrayList<>();
        s = ss;
        words = wordDict;
        len = s.length();
        dfs(new ArrayList<>(),0);
        return res;
    }

    private static void dfs(ArrayList<String> list, int start) {
        if (start == len){
            res.add(String.join(" ",list));
        }

        for (int i = start+1;i<=len;i++){
            if (words.contains(s.substring(start,i))){
                list.add(s.substring(start,i));
                dfs(list,i);
                list.remove(list.size()-1);
            }
        }
    }
}
