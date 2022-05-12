package com.zms.middle;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author: zms
 * @create: 2022/3/2 11:07
 */

public class main32 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
      Queue<TreeNode> queue = new ArrayDeque<>();
      List<List<Integer>> res = new ArrayList<>();
      if(root == null) return res;
     queue.add(root);
     boolean flag = false;
        while(!queue.isEmpty()){
            int curLevelcount = queue.size();
            Deque<Integer> deque = new ArrayDeque<>();
            while(curLevelcount>0){
                TreeNode treeNode = queue.poll();
                if(flag){
                    deque.addFirst(treeNode.val);
                }else{
                    deque.addLast(treeNode.val);
                }
                if(treeNode.left != null)
                    queue.add(treeNode.left);
                if (treeNode.right != null)
                    queue.add(treeNode.right);
                curLevelcount--;

            }
            flag = flag == true? false:true;
            res.add(new ArrayList<Integer>(deque));
     }
        return res;
    }
}
