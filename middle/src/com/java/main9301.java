package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/27 10:38
 */
public class main9301 {
    public static void main(String[] args) {
        restoreIpAddresses("101023");
    }
    public static List<String> restoreIpAddresses(String s) {
        //101154235110
        //101.154.235.110
        ArrayList<String> res = new ArrayList<>();
        dfs(0,0,res,new StringBuilder(),s);
        return res;
    }

    private static void dfs(int start, int cur, ArrayList<String> res, StringBuilder sb,String s) {
        if(cur == 3 ){
            if(valid(s,start,s.length()-1)){
                sb.append("."+s.substring(start));
                res.add(sb.toString());
                return;
            }else return;
        }


        for(int i = start; i < s.length(); i ++){
            if(valid(s,start,i)){
                int lensb = sb.length();
                if (cur == 0 ){
                    sb.append(s.substring(start,i+1));
                }else{
                    sb.append("."+s.substring(start,i+1));
                }
                cur++;
                dfs(i+1,cur,res,sb,s);
                cur--;
                sb.delete(lensb,sb.length());
            }
        }





    }
    //判断是否是一段有效的ip地址
    private static boolean valid(String s,int start,int end) {
        int len = end - start +1;
        if(len==0) return false;
        if(len > 3) return false;
        if(len==1) return true;
        if(s.charAt(start)=='0') return false;
        int i = Integer.parseInt(s.substring(start,end+1));
        if(i>=1 && i <=255) {
            return true;
        }
        return false;
    }
}
