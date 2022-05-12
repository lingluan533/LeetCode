package com.java;

/**
 * @author: zms
 * @create: 2022/1/4 9:15
 */
public class main21 {

    class  ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            head.next = null;
            ListNode p = head;
            ListNode tem;
            while (list1!=null && list2 != null){

                if(list1.val < list2.val){
                    tem = list1.next;
                    list1.next = null;
                    p.next = list1;
                    list1 = tem;
                    p = p.next;
                }else if(list1.val == list2.val){
                    tem = list1.next;
                    list1.next = null;
                    p.next = list1;
                    list1 = tem;
                    p = p.next;

                    tem = list2.next;
                    list2.next = null;
                    p.next = list2;
                    list2 = tem;
                    p = p.next;
                }else{
                    tem = list2.next;
                    list2.next = null;
                    p.next = list2;
                    list2 = tem;
                    p = p.next;
                }
            }
            if(list1 != null)p.next = list1;
            if (list2 != null) p.next = list2;
            return head.next;
    }
}
