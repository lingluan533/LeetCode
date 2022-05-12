package com.java;

/**
 * @author: zms
 * @create: 2022/3/19 21:44
 */
public class main23604 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return null;
        if(root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;
        return root;

    }
}
