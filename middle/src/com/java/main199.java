package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/3/20 17:36
 */
public class main199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
       // LinkedList linkedList = new LinkedList();  实现了Deque , 而 Deque又继承自 Queue
        Queue<TreeNode> queue = new ArrayDeque<>();  //
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                TreeNode poll = queue.poll();
                if(poll.left != null ) queue.add(poll.left);
                if(poll.right != null) queue.add(poll.right);
                if(size == 0){
                    list.add(poll.val);
                }
            }
        }


        return list;
    }
}
