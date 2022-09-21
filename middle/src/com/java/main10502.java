package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/9/5 20:21
 */
public class main10502 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder);
    }

    private TreeNode build(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        int rootval = preorder[0];
        TreeNode node = new TreeNode(rootval);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootval) {
                index = i;
                break;
            }
        }
        node.left = build(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = build(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }
}
