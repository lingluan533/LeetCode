package com.java;

import com.java.utils.ListNode;

import java.util.List;

/**
 * @author: zms
 * @create: 2022/4/10 17:07
 */
public class main86 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2))))));
        partition(root,3);
    }
    public static ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode preA = new ListNode();
        ListNode curA = preA;
        ListNode preB = new ListNode();
        ListNode curB = preB;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null){
            if(cur.val < x){
                cur.next = null;
                curA.next = cur;
                curA = cur;
                cur = next;
                if (next!= null) next = next.next;
            }else{
                cur.next = null;
                curB.next = cur;
                curB = cur;
                cur = next;
                if(next != null) next = next.next;
            }
        }
        curA.next = preB.next;
        return preA.next;
    }
}
