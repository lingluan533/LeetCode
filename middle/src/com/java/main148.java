package com.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/1/12 18:36
 */
public class main148 {
    public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        if(head==null) return head;
        while(head!=null){
            pq.add(head);
            head = head.next;
        }
        ListNode newhead = new ListNode();
        ListNode p  = newhead;
        while(!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            p.next = null;
        }
        return newhead.next;

    }
}
