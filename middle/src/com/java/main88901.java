package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/9/5 21:05
 */
public class main88901 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder);
    }

    private TreeNode build(int[] preorder, int[] postorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int rootval = preorder[0];
        int leftrootval = preorder[1];
        int indexofleftroot = 0;
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == leftrootval) {
                indexofleftroot = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootval);
        root.left = build(Arrays.copyOfRange(preorder, 1, 1 + indexofleftroot + 1), Arrays.copyOfRange(postorder, 0, indexofleftroot + 1));
        root.right = build(Arrays.copyOfRange(preorder, 1 + indexofleftroot + 1, preorder.length), Arrays.copyOfRange(postorder, indexofleftroot + 1, preorder.length - 1));
        return root;
    }
}
