package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/9/5 9:41
 */
public class main652 {


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        System.out.println(dfs(root, new HashMap<String, Integer>(), res));
        return res;

    }

    private String dfs(TreeNode root, HashMap<String, Integer> map, ArrayList<TreeNode> res) {
        if (root == null) {
            return "null";
        }
        //nodes.add(root.val + "");
        String str = root.val + "," + dfs(root.left, map, res) + "," + dfs(root.right, map, res);
        if (map.getOrDefault(str, 0) == 1) {
            res.add(root);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }

}
