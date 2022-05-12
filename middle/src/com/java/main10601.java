package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/4/5 15:59
 */
public class main10601 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null ||  postorder == null || inorder.length==0 || postorder.length==0) return null;
        int lenin = inorder.length;
        int postlen = postorder.length;
        TreeNode root = new TreeNode(postorder[postlen-1]);
        int rootindexininorder = 0;
        for(int i = 0;i<lenin;i++){
            if(inorder[i] == postorder[postlen-1]){
                rootindexininorder = i;
                break;
            }
        }
        root.left= buildTree(Arrays.copyOfRange(inorder,0,rootindexininorder),Arrays.copyOfRange(postorder,0,rootindexininorder));
        root.right = buildTree(Arrays.copyOfRange(inorder,rootindexininorder+1,lenin),Arrays.copyOfRange(postorder,rootindexininorder,postlen-1));
        return root;
    }
}
