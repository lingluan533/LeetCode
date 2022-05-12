package com.java;

/**
 * @author: zms
 * @create: 2022/4/4 16:55
 */
public class main22601 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
