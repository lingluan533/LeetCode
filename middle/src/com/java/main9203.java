package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/10/30 15:15
 */
public class main9203 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        int count = 0;
        ListNode pre = preHead;
        ListNode cur = preHead;
        ListNode firstLast = pre;
        // 1 2 3 4 5
        //   2   4
        while (count < left) {
            count++;
            pre = cur;     //最终指向第一段的最后一个
            cur = cur.next;
        }
        firstLast = pre;
        ListNode start = cur;
        while (count <= right) {
            count++;
            pre = cur;     //最终指向第一段的最后一个
            cur = cur.next;
        }
        pre.next = null;
        firstLast.next = reverseList(start);
        start.next = cur;
        return preHead.next;
    }

    public ListNode reverseList(ListNode node) {
        ListNode preHead = new ListNode();
        ListNode p = node;
        ListNode q = node.next;
        while (p != null) {
            p.next = preHead.next;
            preHead.next = p;
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        return preHead.next;
    }
}
