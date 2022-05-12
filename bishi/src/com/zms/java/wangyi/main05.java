package com.zms.java.wangyi;


import java.util.*;

/**
 * @author: zms
 * @create: 2022/3/28 15:32
 */
public class main05 {

    static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }



    }
    public static TreeNode printTree(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(root, set);
        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator);
//        }

        return buildTree(set);
    }
    //
    private static TreeNode buildTree(TreeSet<Integer> set) {
        TreeNode root = new TreeNode();
        if (!set.isEmpty()) {
            root.val = set.pollFirst();
            System.out.println(root.val);
            root.left = buildTree(set);
            root.right = buildTree(set);
        }
        return root;
    }

    private static void dfs(TreeNode root, TreeSet<Integer> set) {
        if (root == null) return;
        if (!set.contains(root.val))
            set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
       TreeNode root1 = new TreeNode(5);
       TreeNode root2 = new TreeNode(6);

       TreeNode root3 = new TreeNode(7);
       TreeNode root4 = new TreeNode(1);
       TreeNode root5 = new TreeNode(6);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        printTree(root);
    }
}




