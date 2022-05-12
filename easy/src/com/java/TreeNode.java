package com.java;

/**
 * @author: zms
 * @create: 2022/3/17 22:19
 */
public class TreeNode {

    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;this.right = right;
      }
  }

