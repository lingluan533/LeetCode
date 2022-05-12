package com.java;

/**
 * @author: zms
 * @create: 2022/4/20 15:24
 */
public class main230 {
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
    public int count = 0;
    public int k=0;
    public int targhet = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        try{
            dfs(root);
        }catch (Exception e){
            return targhet;
        }
        return targhet;
    }

    private void dfs(TreeNode root) throws Exception {
        if(root == null){
            return ;
        }

        dfs(root.left);
        count ++;
        if(count == k){
            this.targhet = root.val;
            throw new Exception();
        }
        dfs(root.right);
    }
}
