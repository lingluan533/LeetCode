package com.java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/1/9 0:27
 */

public class main23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode p = head;
        head.next = null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 0) return head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return  o1.val - o2.val;
            }
        });
        for(int i = 0;i<lists.length;i++){
            if(lists[i]==null) continue;
            pq.add(lists[i]);
        }
        ListNode cur ,curnext;
        while(!pq.isEmpty()){
            cur = pq.poll();
            curnext = cur.next;
            cur.next = null;
            p.next = cur;
            p = cur;
            if(curnext != null){
                pq.add(curnext);
            }
        }


        return head.next;
    }
}
