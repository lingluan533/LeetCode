package com.java;

/**
 * @author: zms
 * @create: 2022/3/18 20:58
 */
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }
      ListNode (int x,ListNode next){
          this.val = x;
          this.next = next;
      }
  }
