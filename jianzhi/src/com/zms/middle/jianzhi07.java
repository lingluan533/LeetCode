package com.zms.middle;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/3/9 9:23
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class jianzhi07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

    return build(preorder,inorder,map);

    }


    public TreeNode build(int[] preorder, int[] inorder,HashMap<Integer,Integer> map){
        if(preorder == null || preorder.length == 0) return null;
        int rootval = preorder[0];
        int rootindexIninorder = map.get(preorder[0]);
//        for(int i = 0;i<inorder.length;i++){
//            if(inorder[i] == preorder[0]){
//                rootindexIninorder = i;
//            }
//        }


        TreeNode root = new TreeNode(rootval);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1+rootindexIninorder),Arrays.copyOfRange(inorder,0,rootindexIninorder));
        root.right = buildTree(Arrays.copyOfRange(preorder,rootindexIninorder+1,preorder.length),Arrays.copyOfRange(inorder,rootindexIninorder+1,inorder.length));
        return root;
    }
}
