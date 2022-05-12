package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/3/2 11:33
 */
public class main50 {
    public char firstUniqChar(String s) {
        int visited [] = new int[26];
        for(int i = 0;i<s.length();i++){
            visited[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            if(visited[s.charAt(i)-'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
