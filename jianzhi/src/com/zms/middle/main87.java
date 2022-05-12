package com.zms.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/16 10:17
 */
public class main87 {
    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(0,0,new StringBuilder(),res,s);
        return res;
    }

    private static void dfs(int start, int cur, StringBuilder stringBuilder, List<String> res,String s) {
        if(cur == 3 ){
                if(isValid(start,s.length(),s)){
                    stringBuilder.append("."+s.substring(start));
                    res.add(stringBuilder.toString());
                    return;
                }else return;
        }

        for(int i = start;i<=s.length();i++){
            if(isValid(start,i,s)){
                int oldlen = stringBuilder.length();
                if(cur==0){
                    stringBuilder.append(s.substring(start,i));
                }else{
                    stringBuilder.append("."+s.substring(start,i));
                }
                cur++;
                dfs(i,cur,stringBuilder,res,s);
                cur--;
                stringBuilder.delete(oldlen,stringBuilder.length());

            }
        }

    }

    private static boolean isValid(int start, int i, String s) {
        if(start == i) return false;
        if(s.charAt(start) == '0' && start + 1 !=i) return false;
        int sum = 0;
        int flag = 1;
        for(int j = i-1;j>=start;j--){
            sum = (s.charAt(j) -'0') * flag + sum;
            flag*=10;
        }
        if(sum >=0 && sum <=255)return true;
        else return false;
    }
}
