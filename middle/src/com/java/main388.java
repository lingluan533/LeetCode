package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/4/20 10:52
 */
public class main388 {
    public int lengthLongestPath(String input) {
        int max = Integer.MIN_VALUE;

        String[] split = input.split("\n");
        HashMap<Integer,String> hashMap = new HashMap<>();
        for(int i = 0;i<split.length;i++){
            System.out.println(split[i]);
            int j = 0;
            int level  = 0;
            while (split[i].charAt(j++) == '\t') level++;
            String curPath = split[i].substring(j-1);
            String orDefault = hashMap.getOrDefault(level - 1 , null);
            String cur = orDefault == null ? curPath : orDefault + "/" + curPath;
            hashMap.put(level,cur);
            if(curPath.contains(".")){
                max = Math.max(max,cur.length());
                System.out.println(cur);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
