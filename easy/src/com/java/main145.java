package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/4 17:04
 */
public class main145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null) return;
        dfs(root.left,res);
        dfs(root.right,res);
        res.add(root.val);
    }
}
