package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/16 11:18
 */
public class main257 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

     public   List<String> res = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {

                dfs(root,res,"");
                return res;
        }

    private void dfs(TreeNode root, List<String> res,String sb) {
            if(root == null) return;
            sb += root.val;
            if(root.left == null && root.right == null) res.add(sb);
            dfs(root.left,res,sb+"->");
            dfs(root.right,res,sb+"->");




    }
}
