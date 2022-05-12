package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/1/7 20:54
 */
class ListNode {
   public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}
public class jianzhi06 {

    public int[] reversePrint(ListNode head) {
       int res [] ;
       int len = 0;
       ListNode tem = head;
       if(head == null ) return new int[]{};
       while(head != null){
           head = head.next;
           len++;
       }
       res = new int[len];

       for(int i = len-1;i>=0;i--){
           res[i] = tem.val;
           tem = tem.next;
       }
        return res;
    }
}
