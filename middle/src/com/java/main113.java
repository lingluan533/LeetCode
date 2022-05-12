package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/7 21:34
 */
public class main113 {
    public static void main(String[] args) {
        TreeNode r5 = new TreeNode(5);
        TreeNode r4 = new TreeNode(4);
        TreeNode r8= new TreeNode(8);
        TreeNode r11 = new TreeNode(11);
        TreeNode r13 = new TreeNode(13);
        TreeNode rr4 = new TreeNode(4);
        TreeNode r7 = new TreeNode(7);
        TreeNode r2 = new TreeNode(2);
        TreeNode r5r = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);

       r5.left = r4;
       r5.right = r8;
       r4.left = r11;
       r11.left = r7;
       r11.right = r2;
       r8.left = r13;
       r8.right = rr4;
       rr4.left = r5r;
       rr4.right = r1;
       pathSum(r5,22);
    }
   static List<List<Integer>> res ;
    static int target;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        res = new ArrayList<>();
        if(root == null) return res;
        dfs(root,new ArrayList<Integer>(),0);
        return res;
    }

    private static void dfs(TreeNode root, ArrayList<Integer> path,int sum) {
        if(root == null){

            return ;
        }
        path.add(root.val);
        sum += root.val;
        if(sum == target && root.left==null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        dfs(root.left,path,sum);
        dfs(root.right,path,sum);
        sum-= root.val;
        path.remove(path.size()-1);
    }
}
