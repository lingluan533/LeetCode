package com.java;

/**
 * @author: zms
 * @create: 2022/4/4 20:40
 */
public class main9701 {
    char cs1[] ,cs2[],cs3[];
    boolean vis[][] ;
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if( len1 + len2 != len3) return false;
        this.cs1 = s1.toCharArray();
        this.cs2 = s2.toCharArray();
        this.cs3 = s3.toCharArray();
        this.vis = new boolean[len1][len2];
       return dfs(0,0,0);
    }

    private boolean dfs(int i, int j, int k) {
        if(k == cs3.length){
            return true;
        }
        if( i > cs1.length || j > cs2.length ||  vis[i][j]) return false;
        vis[i][j]  = true;
        if(i < cs1.length && cs1[i] == cs3[k] && dfs(i+1,j,k+1)) return true;
        if(j < cs2.length && cs2[j] == cs3[k] && dfs(i,j+1,k+1)) return true;
        vis[i][j] = false;
        return false;
    }
}
