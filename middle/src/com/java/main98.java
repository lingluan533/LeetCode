package com.java;

/**
 * @author: zms
 * @create: 2022/3/17 21:39
 */

public class main98 {
     long pre = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
       return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if(root == null) return true;
        if(!dfs(root.left))
            return false;
        if(root.val <= pre)return false;
        pre = root.val;
        return dfs(root.right);
    }
}
