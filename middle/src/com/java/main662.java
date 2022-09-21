package com.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: zms
 * @create: 2022/8/27 23:04
 */
public class main662 {
    class Node{
        TreeNode node;
        int idx;
        public Node(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(root,1));
        int max = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            Node left = queue.getFirst();
            Node right = queue.getLast();
            max = Math.max(max,right.idx-left.idx+1);
            while (size>0){
                Node poll = queue.poll();
                int idx = poll.idx;
                size--;
                if (poll.node.left!=null){
                    queue.offer(new Node(poll.node.left,idx*2));
                }
                if (poll.node.right!=null){
                    queue.offer(new Node(poll.node.right,idx*2+1));
                }
            }
        }
        return max;
    }
}
