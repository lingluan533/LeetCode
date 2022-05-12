package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/4/21 11:37
 */
public class main142 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        detectCycle(l1);
    }
    public static ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head.next == head) return head;
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast  = fast.next.next;
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle) return null;
        ListNode q =head;

        while(q!=slow){
            q = q.next;
            slow = slow.next;
        }
        return q;
    }
}
