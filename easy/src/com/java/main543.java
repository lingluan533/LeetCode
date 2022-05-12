package com.java;

/**
 * @author: zms
 * @create: 2022/4/4 16:35
 */
public class main543 {
    public static void main(String[] args) {

    }
    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        getDepth(root.left);
        getDepth(root.right);


        return max;
    }

    private int getDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        max = Math.max(max,left + right);

        return Math.max(left,right) + 1;
    }
}
