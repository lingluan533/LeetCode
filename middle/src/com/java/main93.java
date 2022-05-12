package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/13 9:11
 */
public class main93 {
    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }
    public static  List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        dfs(0,0,s,res,stringBuilder);

        return  res;
    }
    //start:本轮开始截取的起始位置
    //cur:当前判断的断点的个数

    private static void dfs(int start, int cur, String s, List<String> res,StringBuilder sb) {
            if(cur == 3){
                if(isValid(s,start,s.length())){
                    sb.append("."+s.substring(start));
                    res.add(sb.toString());
                    System.out.println(sb.toString());
                }else{
                    return ;
                }
                //判断合法性
            }
            for(int i = start;i<=s.length();i++){
                if(isValid(s,start,i)){
                    int lensb = sb.length();
                    if(cur==0)
                    sb.append(s.substring(start,i));
                    else    sb.append("."+s.substring(start,i));
                    cur++;
                    dfs(i,cur,s,res,sb);
                    sb.delete(lensb,sb.length());
                    cur--;
                }

            }
    }

    private static boolean isValid(String s, int start, int i) {
        if(start == i) return false;
        if(s.charAt(start) == '0' && start +1 != i) return false;
        if(start +1 == i) return true;
        int res = 0;
        int flag = 1;
        for(int j = i-1;j>=start;j--){
            res = (s.charAt(j)-'0') * flag + res;
            flag *=10;
        }
        if(res >=0 && res <= 255) return true;
        else return false;
    }
}
