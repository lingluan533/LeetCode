package com.java;

/**
 * @author: zms
 * @create: 2022/4/21 10:14
 */
public class main114 {
    public class TreeNode {
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
    public void flatten(TreeNode root) {
        TreeNode newRoot = new TreeNode(root.val);

        dfs(root,newRoot);
        root = newRoot;
    }

    private void dfs(TreeNode root, TreeNode newRoot) {
        if(root == null) return;
        TreeNode node = new TreeNode(root.val);
        newRoot.right = node;
        dfs(root.left,node);
        dfs(root.right,node);
    }
}
