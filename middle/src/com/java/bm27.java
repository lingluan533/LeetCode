package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/4/1 11:42
 */
public class bm27 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left=node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Print(node1);

    }
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList();
        if(pRoot == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        boolean flag = true;
        while(!queue.isEmpty()){
            int curLen = queue.size();
            ArrayList<Integer> list = new ArrayList();
            while(curLen > 0){
                TreeNode node =  queue.poll();
                list.add(node.val);
                curLen --;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            if(flag){
                res.add(list);
            }else{
                Collections.reverse(list);
                res.add(list);
            }
            flag = !flag;
        }
        return res;
    }
}
