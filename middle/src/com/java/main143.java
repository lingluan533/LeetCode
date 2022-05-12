package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/3/16 9:09
 */

public class main143 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
     ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3); ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        reorderList(head);


    }
    public static void reorderList(ListNode head) {
            //
        Stack<ListNode> stack = new Stack<>();
        if(head.next == null)return;
        if(head.next.next == null) return;
        //先遍历一遍找到后半部分的第一个节点
        int count = 0;
        int postStart = 0;
        ListNode cur = head;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        if(count %2==0){
            postStart = count /2 +1;
        }else{
            postStart = count/2+2;
        }
        //再遍历压栈后面的部分
        count = 1;
        cur = head;
        while(cur != null && count<postStart-1){
            count++;
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        cur = next;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = null;
            stack.push(cur);
            cur = temp;
        }

        //最后出栈 插入原链表中
        cur = head;
        boolean falg = true;
        while (!stack.isEmpty() ){
            if(!falg){

                cur = cur.next;
                falg = ! falg;
                continue;
            }
            ListNode pop = stack.pop();
            pop.next = cur.next;
            cur.next = pop;
            cur = cur.next;
            falg = ! falg;
        }

    }
}
