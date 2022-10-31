package com.zms.java;

/**
 * @author: zms
 * @create: 2022/10/26 16:05
 */
public class mainhw2 {

    public static void main(String[] args) {
        
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode reverse = reverse(1, 6, listNode);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int _val) {
            this.val = _val;
        }

        public ListNode() {
        }
    }

    public static ListNode reverse(int l, int r, ListNode head) {
        //  1 2 3 4 5 6   ->   1 4 3 2 5 6
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = head;
        ListNode preLast = head;
        ListNode next = head;
        ListNode mid = null;
        int count = 1;
        while (count < l && pre != null) {
            if (count == l - 1) {
                preLast = pre;  // 前段最后一个
            }
            pre = pre.next;
            count++;
        }
        mid = pre; // 中间部分
        while (count < r && pre != null) {
            pre = pre.next;
            count++;
        }
        next = pre.next;
        pre.next = null;
        preLast.next = null;
        preLast.next = reverseList(mid);  // 拼接三段
        mid.next = next;
        return dummy.next;
    }

    public static ListNode reverseList(ListNode node) {
        ListNode dummy = new ListNode();
        ListNode p = node.next;
        while (node != null) {
            node.next = dummy.next; // 头插法 插入
            dummy.next = node;
            node = p;
            if (node != null) { // 后移
                p = p.next;
            }
        }
        return dummy.next;
    }
}
