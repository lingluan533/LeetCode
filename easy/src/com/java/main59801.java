package com.java;

import sun.java2d.pipe.AAShapePipe;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/3/11 9:49
 */

public class main59801 {
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

    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();

        List<Integer> res  = new ArrayList<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            Node last = stack.pop();


            //遍历子链，加入到队列中
            Deque<Node> deque = new ArrayDeque<>();
            for(int i = 0;i<last.children.size();i++){
                deque.addFirst(last.children.get(i));
            }
            res.add(last.val);//添加节点值到结果集
            while(!deque.isEmpty()){
                stack.push(deque.pop());
            }
        }
        return res;
    }
}
