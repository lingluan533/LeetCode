package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/3/9 10:20
 */
public class main92 {
 static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode h = new ListNode(3);
        h.next=new ListNode(5,null);

        reverseBetween(h,1,2);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
     if(left == right) return head;
     ListNode before = new ListNode(Integer.MIN_VALUE);
     ListNode after = new ListNode();
     Stack<ListNode> stack = new Stack<>();
        int i = 0;
        //ListNode aheadHead = null;
        ListNode p = head;

        if(left > 1){
            before = head;
            p = p.next;
            i++;

        }

        while(i< left -1 ){
            before =p;
            p = p.next;
            i++;
        }

        while(i<right){
            stack.push(new ListNode(p.val));
            p = p.next;
            i++;
        }
       after = p;
       ListNode q = before;
        while(!stack.isEmpty()){
            if(stack.size()!=1) {
                q.next = new ListNode(stack.pop().val);
                q = q.next;
            }else{
                q.next = new ListNode(stack.pop().val,after);
            }
        }

        return before.val == Integer.MIN_VALUE? before.next:head;

    }

}
