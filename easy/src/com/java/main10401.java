package com.java;

/**
 * @author: zms
 * @create: 2022/3/17 22:18
 */
public class main10401 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) +1 ;
    }
}
