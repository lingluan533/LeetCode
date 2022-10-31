package com.java;

/**
 * @author: zms
 * @create: 2022/10/30 16:33
 */
public class main2503 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseKGroup(node, 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        int count = 0;
        ListNode pre = preHead;
        ListNode cur = preHead;
        while (cur.next != null) {
            while (count < k && cur != null) {
                count++;
                cur = cur.next; // 走到当前组的最后一个元素
            }
            if (cur == null) {
                break;
            }
            count = 0;

            ListNode next = cur.next; // 记录之后的元素为next
            ListNode start = pre.next; // 当前组的第一个元素为上一组的最后一个元素的后面一个元素
            cur.next = null;  //当前组断开与后续的连接
            ListNode no = reverseList(start); // 反转当前组 返回反转后的第一个元素
            pre.next = no; // 上一个组的最后一个元素的后面连接上反转后的第一个元素
            start.next = next; //当前组的最后一个元素连接上后续的元素
            pre = start;  //工作指针后移
            cur = start; //工作指针后移
        }
        return preHead.next;
    }

    private static ListNode reverseList(ListNode node) {
        ListNode preHead = new ListNode();

        ListNode p = node;
        ListNode q = node.next;
        while (p != null) {
            p.next = preHead.next;
            preHead.next = p;
            p = q;
            if (q != null) q = q.next;
        }
        return preHead.next;
    }
}
