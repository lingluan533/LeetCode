package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/4/6 19:40
 */
public class main6101 {
    public ListNode rotateRight(ListNode head, int k)
    {   if(head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 1;
        while (cur.next != null){
            count++;
            cur = cur.next;
        }
        cur.next = head;  //闭合成环
        int flag = count - k % count;
        int curLen = 0;
        cur = head;
        while (curLen < flag){
            curLen ++;
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        return next;


    }
}
