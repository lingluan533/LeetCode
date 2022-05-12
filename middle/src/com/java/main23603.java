package com.java;

import java.util.ArrayList;

/**
 * @author: zms
 * @create: 2022/3/19 21:14
 */
public class main23603 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathTop = new ArrayList<>();
        ArrayList<TreeNode> pathToq = new ArrayList<>();
        pathToNode(pathTop,root,p);
        pathToNode(pathToq,root,q);
        int minlen = Math.min(pathTop.size(),pathToq.size());
        TreeNode res = root;
        for(int i = 0;i<pathTop.size();i++){
            System.out.print(pathTop.get(i).val+" ");

        }
        System.out.println();
        for(int i = 0;i<pathToq.size();i++){
            System.out.print(pathToq.get(i).val+" ");

        }
        System.out.println();
        for(int i = 0;i<minlen;i++){
            if(pathTop.get(i).val == pathToq.get(i).val){
                res = pathTop.get(i);
            }
        }
        return res;
    }

    private boolean pathToNode(ArrayList<TreeNode> pathTop, TreeNode root, TreeNode p) {
            if(root == null) return false;

            pathTop.add(root);
            if(root == p) return true;
            if(pathToNode(pathTop,root.left,p)) return true;
            if(pathToNode(pathTop,root.right,p)) return true;
            pathTop.remove(pathTop.size()-1);
            return false;

    }
}
