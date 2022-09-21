package com.java;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author: zms
 * @create: 2022/8/14 20:57
 */
public class main23503 {
    public static void main(String[] args) {

    }
    ArrayList<TreeNode> pathP;
    ArrayList<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)  {
        this.pathP = new ArrayList<>();
        this.pathQ = new ArrayList<>();
        try {
            dfs(root,p,pathP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dfs(root,q,pathQ);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int min = Math.min(pathP.size(),pathQ.size());
        int i = 0;
        while (i<min && pathP.get(i) == pathQ.get(i)){
            i++;
        }
        if(i==min){
            return pathP.get(min - 1);
        }else{
            return pathP.get(i - 1);
        }
    }

    private  static  void dfs(TreeNode root,TreeNode tar,ArrayList<TreeNode> path) throws Exception {
        if(root == null) return ;
        if (root.val == tar.val){
            throw new Exception("d");
        }
            path.add(root);
            dfs(root.left,tar,path);
            dfs(root.right,tar,path);
            path.remove(path.size()-1);


    }
}
