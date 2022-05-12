package com.java;

/**
 * @author: zms
 * @create: 2022/4/21 10:36
 */
public class main11401 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
       TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
         TreeNode node4 = new TreeNode(4);
         TreeNode node5 = new TreeNode(5);
         TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left  = node3;
        node2.right = node4;
        node5.right = node6;
        flatten(node1);
    }
    public static void flatten(TreeNode root) {
        dfs(root);
    }

    private static void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);
        if (root.left != null){
            TreeNode tem = root.left;
            while (tem.right!=null){
                tem = tem.right;
            }
            tem.right = root.right;
           // root.left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
