package com.java;

/**
 * @author: zms
 * @create: 2022/3/12 14:21
 */
public class main112 {

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(2);
        hasPathSum(root,root.val);
    }
       static class TreeNode {
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
    public static boolean hasPathSum(TreeNode root, int targetSum) throws Exception {
            if(root == null ) return false;
           try{
               dfs(root,targetSum,0,0);
           }catch (Exception e){
               return true;
           }
           return false;
    }

    private static void dfs(TreeNode root, int targetSum, int sum ,int len ) throws Exception {

           if( sum == targetSum && root.left==null && root.right == null ){
               throw new Exception();
           }

           if(root == null)return ;
           sum += root.val;
             dfs(root.left,targetSum,sum,len);
             dfs(root.right,targetSum,sum,len);
             sum-= root.val;



    }
}
