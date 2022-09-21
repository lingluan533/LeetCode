package com.java;

/**
 * @author: zms
 * @create: 2022/8/8 22:42
 */
public class main392 {
    public static void main(String[] args) {
        isSubsequence("aaaaaa"
                ,"bbaaaa");
    }
    public static  boolean isSubsequence(String s, String t) {
        char cs[] = s.toCharArray();
        char ct[] = t.toCharArray();
        int cur = 0;
        for(int i=0;i<cs.length;i++){
            int j = cur;
            if(j==ct.length)return false;
            boolean flag = false;
            for(;j<ct.length;j++){
                if(ct[j] == cs[i]){
                    cur = ++j;
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
}
