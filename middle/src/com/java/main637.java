package com.java;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author: zms
 * @create: 2021/12/25 21:22
 */
public class main637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
    }
    private static class TreeNode {
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

    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean flag = true;
        while (!deque.isEmpty()){
            int cursize = deque.size();
            System.out.println(cursize );
            System.out.println("奇偶："+flag);
            if (flag){  //true表示偶数层
                int min = deque.peek().val;
                int temp = cursize;
                while(temp > 0 && deque.peek().val %2!=0  ){
                    TreeNode a =  deque.poll();
                    temp--;
                    if (a.val > min || temp+1 == cursize ){
                        min = a.val;
                        if (a.left != null)
                            deque.add(a.left);
                        if (a.right != null)
                            deque.add(a.right);
                    }else{
                        return false;
                    }
                }if(temp == 0)
                flag = false;
                else{
                    return false;
                }
            }else{
                int max = deque.peek().val;
                int temp = cursize;
                while(  temp > 0 && deque.peek().val %2==0  ){
                    TreeNode a =  deque.poll();
                    temp--;
                    if (a.val <max ||  temp+1 == cursize  ){
                        max = a.val;
                        if (a.left != null)
                            deque.add(a.left);
                        if (a.right != null)
                            deque.add(a.right);
                    }else{
                        return false;
                    }
                }
                if(temp == 0)
                    flag = true;
                else{
                    return false;
                }
            }

        }

        return true;
    }
}
