package com.java;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/3/10 22:57
 */


public class mianshi0403 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return null;
        Queue<Object[]> queue = new ArrayDeque<>();
        Object[] objects = new Object[2];
        objects[0] = tree;
        objects[1] = 0;
        ArrayList<ListNode>  res = new ArrayList<>();
        queue.add(objects);
        int curLen  = 0;
        while(!queue.isEmpty()){
            //构建当层的链
            ListNode head = new ListNode(-1);
            ListNode p = head;
            while(!queue.isEmpty() && (Integer)queue.peek()[1] == curLen){
              TreeNode  node =   (TreeNode)queue.poll()[0];
              if(node.left != null){
                  queue.add(new Object[]{node.left,curLen+1});
              }
              if(node.right != null){
                  queue.add(new Object[]{node.right,curLen+1});
              }
                p.next = new ListNode((node).val);
                p = p.next;
            }
            res.add(head.next);
            //添加到结果集
        curLen ++;
        }
        ListNode [] ress = new ListNode[res.size()];
        int i = 0;
    for(ListNode node : res){
        ress[i] = node;
        i++;
    }
        return ress;
    }
}
