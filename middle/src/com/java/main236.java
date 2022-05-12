package com.java;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/4 11:56
 */
public class main236 {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pathtop = new LinkedList<>();
        LinkedList<TreeNode> pathtoq = new LinkedList<>();

         findToNodePath(root,p,pathtop);
         findToNodePath(root,q,pathtoq);
         for(TreeNode t1: pathtop){
             System.out.print(t1.val+" ");
         }
        System.out.println();
        for(TreeNode t2: pathtoq){
            System.out.print(t2.val+" ");
        }
        int i;
        for(i=0;i<Math.min(pathtop.size(),pathtoq.size());i++){
                if(pathtop.get(i) == pathtoq.get(i))continue;
                else break;
         }
        if(i == Math.min(pathtop.size(),pathtoq.size())) return pathtop.size() <= pathtoq.size() ? pathtop.get(pathtop.size()-1) : pathtoq.get(pathtoq.size()-1);
        return pathtop.get(i-1);

    }

    private boolean findToNodePath(TreeNode root, TreeNode p, LinkedList<TreeNode> pathtop) {
        if(root == null ) return false;
        pathtop.add(root);
         if(root == p) return true;


         if(findToNodePath(root.left,p,pathtop))  return true;
        if( findToNodePath(root.right,p,pathtop)) return true;
         pathtop.removeLast();
        return  false;

    }
}
