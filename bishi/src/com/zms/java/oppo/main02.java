package com.zms.java.oppo;

import com.java.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/9/2 15:14
 */
public class main02 {
    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode cur = node1;
        ListNode next = cur.next;
        while (cur!=null){
            cur.next = null;
            q.add(cur);
            cur = next;
            if(next!=null) next = next.next;
        }

        cur = node2;
        next = cur.next;
        while (cur!=null){
            cur.next = null;
            q.add(cur);
            cur = next;
            if(next!=null) next = next.next;
        }

        ListNode preHead = new ListNode();
        cur = preHead;
        while (!q.isEmpty()){
            ListNode poll = q.poll();
            cur.next = poll;
            cur = cur.next;
        }
        return preHead.next;

    }
}
