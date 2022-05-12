package com.java;

import javafx.beans.property.ReadOnlyObjectProperty;

/**
 * @author: zms
 * @create: 2022/4/7 17:27
 */
public class main437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode r1 = new TreeNode(5);
        TreeNode r2= new TreeNode(-3);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(2);
        TreeNode r5 = new TreeNode(3);
        TreeNode r6 = new TreeNode(-2);
        TreeNode r7 = new TreeNode(1);
        TreeNode r8 = new TreeNode(11);

        root.left = r1;
        root.right = r2;
        r1.left =  r3;
        r1.right = r4;
        r2.right = r8;
        r3.left = r5;
        r3.right = r6;
        r4.right = r7;
    pathSum(root,8);
    }
    static int target ;
    static int sum = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if(root == null) return 0;
        dfs(root);
        return  sum;
    }

    private static void dfs(TreeNode root) {
        if(root == null) return ;
        newDfs(root,target);
        dfs(root.left);
        dfs(root.right);
    }

    private  static void newDfs(TreeNode root,int target) {

            if(target == 0){
                sum++;
                return;
            }
            if(root == null){
                return;
            }
            target-= root.val;
            newDfs(root.left,target );
            target+=root.val;
            target-= root.val;
            newDfs(root.right,target);
            target += root.val;
    }
}
