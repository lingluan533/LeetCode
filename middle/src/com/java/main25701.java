package com.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/16 11:29
 */
public class main25701 {
    class TreeNode {
        int val;
        TreeNode left;TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public  List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {

        dfs(root,res,new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root, List<String> res, StringBuilder sb) {
        if(root == null)return;
        sb.append(root.val + "->");  //先加上這一層的數字
        if(root.left==null && root.right == null){
            res.add(sb.toString());

        }

        dfs(root.left,res,sb);
        dfs(root.right,res,sb);
        sb.delete(sb.length()-3,sb.length());
    }

}
