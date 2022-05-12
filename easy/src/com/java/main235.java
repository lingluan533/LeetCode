package com.java;

import java.util.ArrayList;

/**
 * @author: zms
 * @create: 2022/4/20 15:45
 */
public class main235 {

    ArrayList<TreeNode> pathtoP;
    ArrayList<TreeNode> pathtoQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.pathtoP = new ArrayList<>();
        this.pathtoQ = new ArrayList<>();
        try {
            dfs(root,pathtoP,p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dfs(root,pathtoQ,q);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int min = Math.min(pathtoP.size(),pathtoQ.size());
        int i = 0;
        while (i<min && pathtoP.get(i) == pathtoQ.get(i)){
            i++;
        }
        if(i==min){
            return pathtoP.get(min - 1);
        }else{
            return pathtoP.get(i - 1);
        }
    }

    private void dfs(TreeNode root, ArrayList<TreeNode> pathtox, TreeNode x) throws Exception {
        if(root == null) return;

        if(x.val > root.val){
            pathtox.add(root);
            dfs(root.right,pathtox,x);
            pathtox.remove(pathtox.size() - 1);
        }else if(x.val < root.val){
            pathtox.add(root);
            dfs(root.left,pathtox,x);
            pathtox.remove(pathtox.size() - 1);
        }
        else {
            pathtox.add(root);
            throw new Exception();
        }


    }
}
