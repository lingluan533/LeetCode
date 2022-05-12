package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: zms
 * @create: 2022/4/19 12:02
 */
public class main124 {
     static class TreeNode {
      int val;
      TreeNode left;TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  /**
   * create by: zms
   * description: TODO 由二叉树构建一个图，dfs图中的每一个节点，然后求最长的路径
   * create time: 2022/4/19 12:03
   *
   No such property: code for class: Script1
   * @return
   */
  public static void main(String[] args) {
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(9);
      TreeNode node3 = new TreeNode(20);
      TreeNode node4 = new TreeNode(15);
      TreeNode node5 = new TreeNode(7);
      node1.left = node2;
      node1.right = node3;
      node3.left = node4;
      node3.right = node5;
      maxPathSum(node1);
  }
  static HashMap<Integer , ArrayList<Integer>> hashMap;
    static int maxLen = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        hashMap = new HashMap<>();
        if (root.left  == null  && root.right == null) return root.val;
        dfs(root);

        Set<Integer> set = hashMap.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            dfs1(next,0,new boolean[30000]);
        }
        return maxLen;
    }

    private static void dfs1(Integer next, int sum,boolean vis[]) {
        maxLen = Math.max(maxLen,sum);
        ArrayList<Integer> list = hashMap.get(next);
        if(list == null) return ;
        for(int i = 0; i < list.size();i++){
            if(vis[list.get(i)]) continue;
            sum += next;
            vis[list.get(i)] = true;
            dfs1(list.get(i),sum,vis);
            sum -= next;
            vis[list.get(i)] = false;
        }
    }

    private  static void dfs(TreeNode root) {
        if(root == null) return ;
        if(root.left != null){
            if(hashMap.containsKey(root.val)){
                hashMap.get(root.val).add(root.left.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.left.val);
                hashMap.put(root.val,list);
            }
            if(hashMap.containsKey(root.left.val)){
                hashMap.get(root.left.val).add(root.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                hashMap.put(root.left.val,list);
            }
        }

        if(root.right != null) {
            if(hashMap.containsKey(root.val)){
                hashMap.get(root.val).add(root.right.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.right.val);
                hashMap.put(root.val,list);
            }
            if(hashMap.containsKey(root.right.val)){
                hashMap.get(root.right.val).add(root.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                hashMap.put(root.right.val,list);
            }
        }

        dfs(root.left);
        dfs(root.right);
    }
}
