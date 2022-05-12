package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/3/16 9:53
 */
public class main105 {
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

    public static void main(String[] args) {
        int a [] = new int[]{14,12,45,44,10,2,3,4};
        int[] ints = Arrays.copyOfRange(a, 0, 3);
        for(Integer i : ints){
            System.out.println(i);
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         if(preorder == null || preorder.length == 0){
             return null;
         }
         TreeNode node = new TreeNode(preorder[0]);
         int target = 0;
         for(int i = 0;i< inorder.length;i++){
             if(inorder[i] == preorder[0]){
                 target = i;
                 break;
             }
         }
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, target+1),Arrays.copyOfRange(inorder,0,target));
         node.right = buildTree(Arrays.copyOfRange(preorder,target+1,preorder.length),Arrays.copyOfRange(inorder,target+1,inorder.length));
//       int nextPre [] = new int[target];
//         int nextIn [] = new int[inorder.length - target-1];
//         System.arraycopy(preorder,1,nextPre,0,target);
//         System.arraycopy(inorder,0,nextIn,0,target);
//         node.left = buildTree(nextPre,nextIn);
//
//        int rnextPre [] = new int[target];
//        int rnextIn [] = new int[inorder.length - target-1];
//        System.arraycopy(preorder,target+1,rnextPre,0,preorder.length - target -1 );
//        System.arraycopy(inorder,target+1,rnextIn,0,preorder.length - target -1);
//         node.right = buildTree(rnextPre,rnextIn);

         return node;

    }
}
