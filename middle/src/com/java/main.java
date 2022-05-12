package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/16 10:55
 */
public class main {
    class TreeNode {
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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        dfs(root,target,new ArrayList<Integer>(),list);
        return list;
    }

    private void dfs(TreeNode root, int targetSum, ArrayList<Integer> path,List<List<Integer>> res ) {
        if(root == null) return ;
        path.add(root.val);
        targetSum -= root.val;

        if(targetSum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        dfs(root.left,targetSum,path,res);
        dfs(root.right,targetSum,path,res);
        path.remove(path.size()-1);



    }
}
