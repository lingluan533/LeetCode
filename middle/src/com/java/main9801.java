package com.java;

/**
 * @author: zms
 * @create: 2022/3/17 22:04
 */

public class main9801 {
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
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return dfs(root,null,null);
    }

    private boolean dfs(TreeNode root ,Integer lower,Integer upper) {
        if(root == null) return true;    //能走到最后说明就没有问题的。
        if(lower != null && root.val <= lower) return false;    //如果在遍历的时候某个点不符合要求 那就说明 不符合定义了
        if(upper!= null && root.val >= upper) return false;
        return dfs(root.left,lower,root.val) && dfs(root.right,root.val,upper);  //把当前节点作为下界检查右子树 把当前节点作为上界检查检查左子树
    }
}
