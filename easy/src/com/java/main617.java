package com.java;


import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zms
 * @create: 2022/1/9 23:34
 */
public class main617 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1==null) return root2;
            if(root2==null) return root1;
     //merge两个root 节点 root1 root2 = (需要) merge两个root节点  &&  merge 两个root节点的左子树 && merge两个root节点的右子树  ok，递归框架出来了
        TreeNode node = new TreeNode(root1.val+root2.val);
        node.left = mergeTrees(root1.left,root2.left);
        node.right = mergeTrees(root1.right,root2.right);
        return node;
    }
}
