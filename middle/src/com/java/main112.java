package com.java;

/**
 * @author: zms
 * @create: 2022/4/7 21:13
 */
public class main112 {
    int target ;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        if(root == null) return false;
        try {
            dfs(root,0);
        }catch (Exception e){
            return true;
        }
        return false;

    }

    private void dfs(TreeNode root, int sum) throws Exception{
        if(root == null) {
            return;
        }
        sum += root.val;
        if(sum == target && root.left==null && root.right == null){
            throw new Exception();
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        sum -= root.val;
    }
}
