package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/5 19:56
 */
public class main13101 {
    public static void main(String[] args) {
        List<List<String>> aab = partition("aab");
        for (int i = 0;i<aab.size();i++){

            System.out.println(Arrays.toString(aab.get(i).toArray()));
        }
    }
    static List<List<String>> res ;
    static String str;
    public static List<List<String>> partition(String s) {
        res = new ArrayList<>();
        str = s;
        List<String> list = new ArrayList<>();
        dfs(0,list);
        return res;
    }

    private static void dfs(int start, List<String> list) {
        if(start == str.length()){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = start; i < str.length();i++){
            if(isPalindrome(str,start,i)){
                list.add(String.valueOf(str.toCharArray(),start,i - start + 1));
                dfs(i+1,list);
                list.remove(list.size()-1);
            }
        }

    }

    private static boolean isPalindrome(String s , int start, int i) {
        char cs[] = s.toCharArray();
        while(start < i && cs[start] == cs[i] ){
            start++;
            i--;
        }
        if(start == i) return true; //毋庸置疑
        if(start + 1 == i) return cs[start] == cs[i];
        if(start-1==i) return true;
        return false;


    }
}
