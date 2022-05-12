package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/11 9:10
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class main589 {
    public List<Integer> preorder(Node root) {
    if(root == null) return new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    dfs(root,res);
    return res;
    }

    private void dfs(Node root,List<Integer> res) {
        if(root == null) return ;

        res.add(root.val);

      for(int i = 0;i<root.children.size();i++) {
          dfs(root.children.get(i), res);
      }
    }

}
