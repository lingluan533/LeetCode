package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/3/15 14:11
 */
public class main39501 {
    public int longestSubstring(String s, int k) { //求s中 每一个字符出现次数都不少于k 的最长子串的长度
        //递归终止条件
        if(s.length() < k){
            return 0;
        }
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<s.length();i++)
        {
        hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i),0)+1);
        }

        for(Character c : hashMap.keySet()){
            if (hashMap.get(c)<k){
                String[] split = s.split(c + "");
                int res = Integer.MIN_VALUE;
                for(int i = 0;i<split.length;i++){
                    res = Math.max(longestSubstring(split[i],k),res);
                }
                return res;
            }
        }
        //没有进入递归调用的时候，说明该字符串所有的字符都满足出现的次数大于等于k次，所以直接返回该字符串的长度即可
        return s.length();


    }
}
