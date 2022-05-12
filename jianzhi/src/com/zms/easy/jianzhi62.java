package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/4/6 20:28
 */
public class jianzhi62 {
    public static void main(String[] args) {
        lastRemaining(5,3);
    }
    public static int lastRemaining(int n, int m) {
        ListNode preHead = new ListNode(-1);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 1;i<n;i++){
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;

        ListNode pre = cur;
        cur = head;
        int count = 1;
        while(cur.next != cur){
            if(count == m){
                //执行删除
                pre.next = cur.next;
                cur = cur.next;
                count = 1;
                continue;
            }
            pre = cur;
            cur = cur.next;
            count++;
        }
        return cur.val;

    }
}
