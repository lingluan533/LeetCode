package com.java;

/**
 * @author: zms
 * @create: 2021/12/28 18:44
 */
public class main25 {

      static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode reverseKGroup(ListNode head, int k) {
          if (k==1) return head;
          ListNode lastlast = new ListNode();
          ListNode first = new ListNode();
          first.next = head;
          lastlast.next = head;
          int temp = 0;
          ListNode p,q,nextfirst=null;
          p = lastlast;
          q = head;
          boolean flag = true;
          while(p!=null){
              while( ++temp <= k && p.next!=null ){
                  p = p.next;
              }
              if (temp <= k){
                  break;
              }
              //指定下一段的第一个元素
              if(p!=null)
              nextfirst = p.next;
              ListNode tempnode;
              tempnode = q;
              while(q!=p){
                tempnode = q.next;
                q.next= p.next;
                p.next = q;
                q = tempnode;
              }
              //连接上一段的
              if(flag) {
                  first.next = p;
                  flag = false;
              }
              lastlast.next = p;
              temp  =0;

              q = nextfirst;
              if(q==null) break;
              while(++temp<k){
                  p=p.next;
              }
              lastlast = p;
              temp  =0;
          }
    return first.next;
    }

    public static void main(String[] args) {
          ListNode n1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        System.out.println(reverseKGroup(n1, 3).next.val);
    }
}
