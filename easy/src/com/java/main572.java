package com.java;

/**
 * @author: zms
 * @create: 2022/3/5 22:58
 */
public class main572 {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

      if(subRoot==null || SameTree(root,subRoot)) return true;    //或者从当前节点为根的树与它是同一棵树 或者以当前节点的左子树与它是同一颗树 或者 以当前节点的右子树与他是同一棵树
      if(root == null ) return false;

      return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }



    public boolean SameTree(TreeNode root, TreeNode subRoot){

        if(root == null && subRoot!=null ||root != null && subRoot==null )return false;
        if(root == null && subRoot==null) return true;
           if(root.val != subRoot.val) return false;
           else  return SameTree(root.left,subRoot.left) && SameTree(root.right,subRoot.right);  //左边是同样的树 右边也是同样的树
    }
}
