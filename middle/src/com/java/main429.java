package com.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/4/8 16:12
 */
public class main429 {
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
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if (root == null) return res;
        queue.add(root);
        while (queue.isEmpty() == false){
            int curLen = queue.size();
            List<Integer> list = new ArrayList<>();
            while (curLen > 0){
                curLen--;
                Node poll = queue.poll();
                list.add(poll.val);
                for(int i = 0;i < poll.children.size();i++){
                    queue.add(poll.children.get(i));
                }
            }
            res.add(list);
        }
        return res;
    }
}
