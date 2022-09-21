package com.java;

import com.java.utils.ListNode;

import java.util.List;

/**
 * @author: zms
 * @create: 2022/9/1 21:28
 */
public class main9201 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3,new ListNode(5));
        reverseBetween(head,1,2);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {

            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode cur = dummy,pre = dummy;
            ListNode preStart = null;
            int count = 0;
            while (count < left){
                pre = cur;
                cur = cur.next;
                count++;
            }
            preStart = cur;
            while (count < right){
                count++;
                cur = cur.next;
            }
            ListNode  next = cur.next;
            cur.next = null;
            ListNode tail =  reverseList(preStart);
            pre.next = tail;
            preStart.next = next;
            return dummy.next;

    }

    public static ListNode reverseList(ListNode start){
        if (start == null) return null;
        ListNode dummy = new ListNode();
        ListNode cur = start;
        ListNode next = cur.next;
        while (cur!=null){
            cur.next = dummy.next;
            dummy.next = cur;
            // cur和next後移  注意next是否已經為空了
            cur = next;
            if (next!=null){
                next = next.next;
            }
        }
        return dummy.next;

    }
}
