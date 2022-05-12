package com.java;

/**
 * @author: zms
 * @create: 2022/3/16 10:11
 */
public class main10501 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {


//        int nextPre [] = new int[target];
//        int nextIn [] = new int[inorder.length - target-1];
////        System.arraycopy(preorder,1,nextPre,0,target);
////        System.arraycopy(inorder,0,nextIn,0,target);
//        node.left = buildTree(nextPre,nextIn);
//
//        int rnextPre [] = new int[target];
//        int rnextIn [] = new int[inorder.length - target-1];
////        System.arraycopy(preorder,target+1,rnextPre,0,preorder.length - target -1 );
////        System.arraycopy(inorder,target+1,rnextIn,0,preorder.length - target -1);
//        node.right = buildTree(rnextPre,rnextIn);

        return  build(preorder,inorder,0, preorder.length-1,0, inorder.length-1,0);

    }
    public TreeNode build(int[] preorder, int[] inorder,int prestart,int preend,int instart,int inend, int target){

        if(prestart > preend || instart > inend){
            return null;
        }
        TreeNode node = new TreeNode(preorder[prestart]);
        int cur = 0;
        for(int i = 0;i< inorder.length;i++){
            if(inorder[i] == preorder[0]){
                cur = i;
                break;
            }
        }

        node.left = build(preorder,inorder,prestart+1,cur - instart + prestart,instart,cur-1,cur);
        node.right = build(preorder,inorder,cur-instart + prestart +1,preend,cur+1,inend,cur);

        return node;
    }

}
