package com.java.utils;

/**
 * @author: zms
 * @create: 2022/4/6 17:54
 */
public class ListNode {
   public int val;
   public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
