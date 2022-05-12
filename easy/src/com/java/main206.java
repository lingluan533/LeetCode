package com.java;

/**
 * @author: zms
 * @create: 2021/12/28 16:20
 */
public class main206 {
    private   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
            ListNode q = head,p = head.next,temp = new ListNode();
            while(q!=null){
                q.next = temp.next;
                temp.next = q;
                q = p;
                if(p==null){
                    break;
                }
                p=p.next;
            }
    return temp.next;
    }
    public static void main(String[] args) {

    }
}
