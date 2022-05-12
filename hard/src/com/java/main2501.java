package com.java;

/**
 * @author: zms
 * @create: 2022/3/29 15:05
 */
public class main2501 {
    public static void main(String[] args) {
        //ListNode n1 = new ListNode(1,new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode n1 = new ListNode(1,new ListNode(2,null));
        System.out.println(reverseKGroup(n1, 3).next.val);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        ListNode p = preHead;
        while( p.next != null){
            int count  = 0;
            while(count < k && p != null){
                p = p.next;
                count ++;
            }
            if(p == null){
                break;
            }
            ListNode next = p.next;
            ListNode start = pre.next;
            p.next = null;
            pre.next  = reverse(start);
            start.next = next; //关键
            pre = start;
            p  = pre;
        }
        return preHead.next;

    }

    private static ListNode reverse(ListNode start) {
        ListNode dummy = new ListNode();
        ListNode next = start.next;
        while (start!=null){
            start.next = dummy.next;
            dummy.next = start;
            if(next!=null){
                start = next;
                next = next.next;
            }else break;
        }
        return dummy.next;
    }
}
