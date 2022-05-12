package com.java;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zms
 * @create: 2022/1/4 10:42
 */
public class main103 {
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

    static class Node {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<Node> pq = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        pq.add(new Node(root, 0));
        Node temp;
        int curlevel = 0;


        List<Integer> list = new ArrayList();
        while (!pq.isEmpty()) {
            temp = pq.poll();
            if (temp.getLevel() == curlevel) {
                list.add(temp.getNode().val);
            }
            else {
                if(curlevel %2 == 1){ //逆序存放
                    Stack<Integer> s = new Stack();
                    for(int j = 0;j<list.size();j++){
                        s.push(list.get(j));
                    }
                   list = new ArrayList();
                    while(!s.isEmpty()){
                        list.add(s.pop());
                    }
                }
                curlevel++;
                res.add(list);

                list = new ArrayList<>();
                list.add(temp.getNode().val);
            }
            if (temp.getNode().left != null) {
                pq.add(new Node(temp.getNode().left, curlevel + 1));
            }
            if (temp.getNode().right != null) {
                pq.add(new Node(temp.getNode().right, curlevel + 1));
            }
        }
        if(curlevel %2 == 1){ //逆序存放
            Stack<Integer> s = new Stack();
            for(int j = 0;j<list.size();j++){
                s.push(list.get(j));
            }
            list = new ArrayList();
            while(!s.isEmpty()){
                list.add(s.pop());
            }
        }
        res.add(list);
        return res;
    }
}
