package com.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/3/10 19:08
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class main2301 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null)
            priorityQueue.add(lists[i]);
        }
        ListNode head = new ListNode(0,null);
        ListNode p = head;
        while(!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            ListNode temp = poll.next;
            poll.next = null;
            p.next = poll;
            p = p.next;
            if(temp!=null){
                priorityQueue.add(temp);
            }
        }
        return head.next;
    }

}
