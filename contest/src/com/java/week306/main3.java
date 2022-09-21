package com.java.week306;

/**
 * @author: zms
 * @create: 2022/8/14 10:25
 */
public class main3 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(smallestNumber("DDD"));
    }
    static  int res = Integer.MAX_VALUE;
    static String pattern="";
    static int len = 0;
    public static String smallestNumber(String patter) {
        pattern = patter;
        len = patter.length();
        for (int i = 1;i<=9;i++){
            boolean vis [] = new boolean[10];
            vis[i] = true;
            dfs(0,vis,new StringBuilder().append(i),i);
        }
        return res+"";
    }

    private static void dfs(int start, boolean vis[],StringBuilder stringBuilder,int pre) {
        if (start==len){
            int i = Integer.parseInt(stringBuilder.toString());
            res = Math.min(res,i);
            return;
        }
        for(int i = 1;i<=9;i++){
            if(vis[i]) continue;
                if(pattern.charAt(start)=='I'){
                    if(i<=pre) continue;
                    stringBuilder.append(i);
                    vis[i] = true;
                    dfs(++start,vis,stringBuilder,i);
                    start--;
                    vis[i] = false;
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }else{
                    if(i>=pre) continue;
                    stringBuilder.append(i);
                    vis[i] = true;
                    dfs(++start,vis,stringBuilder,i);
                    start--;
                    vis[i] = false;
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
        }
    }
}
