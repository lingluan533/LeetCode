package com.java;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author: zms
 * @create: 2022/1/4 9:30
 */
public class main102 {
     static class  TreeNode {
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
  static class Node{
         TreeNode node;
         Integer level;

      @Override
      public String toString() {
          return "Node{" +
                  "node=" + node +
                  ", level=" + level +
                  '}';
      }

      public Node(TreeNode node, Integer level) {
          this.node = node;
          this.level = level;
      }

      public TreeNode getNode() {
          return node;
      }

      public void setNode(TreeNode node) {
          this.node = node;
      }

      public Integer getLevel() {
          return level;
      }

      public void setLevel(Integer level) {
          this.level = level;
      }
  }
    public static List<List<Integer>> levelOrder(TreeNode root) {


        Deque<Node> pq = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        pq.add(new Node(root,0));
        Node temp ;
        int curlevel = 0;
        List<Integer> list = new ArrayList();
        while(!pq.isEmpty()){
            temp = pq.poll();
            if (temp.getLevel()==curlevel)list.add(temp.getNode().val);
            else {
                curlevel ++;
                res.add(list);
                list = new ArrayList<>();
                list.add(temp.getNode().val);
            }
            if(temp.getNode().left != null){
                pq.add(new Node(temp.getNode().left,curlevel+1));
            }
            if(temp.getNode().right != null){
                pq.add(new Node(temp.getNode().right,curlevel+1));
            }
        }
        res.add(list);
        return res;

    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9,null,null);
        p.right = new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null));
         levelOrder(p);
    }
}
