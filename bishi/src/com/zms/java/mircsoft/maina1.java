package com.zms.java.mircsoft;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/8/19 19:01
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class maina1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{ 1, 1,1,9,9,9,9,7,8}, new int[]{2,0,3,1,6,5,4,0,0}));
       // System.out.println(solution(new int[]{ 0,1, 1}, new int[]{1,2,3}));
    }
    public static int solution(int[] A, int[] B) {
        int len = A.length;
        int a[][] = new int[len+1][len+1];
        for (int i = 0;i<len;i++){
            a[A[i]][B[i]] = 1;
            a[B[i]][A[i]] = 1;
        }
        Node root = new Node(0,new ArrayList<>());
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        boolean vis[] = new boolean[len+1];
        int childs[] = new int[len+1];
      while (!deque.isEmpty()){
          int size = deque.size();
          while (size>0){
              Node poll = deque.poll();
              vis[poll.val] = true;
              for(int i = 0;i<=len;i++){
                if(a[poll.val][i] == 1 && !vis[i]){
                    Node t = new Node(i,new ArrayList<>());
                    poll.children.add(t);
                    deque.add(t);
                    childs[poll.val]++;
                }
              }
              size--;
          }
      }
      Deque<Node> dd = new ArrayDeque<>();
      dd.add(root);
      int sum = 0;
        for (int i= 0;i<root.children.size();i++){
            // 加上所有子节点到上一层的花费
            sum += countFees(root.children.get(i),childs);
        }

      return sum;
    }

    public static int countFees(Node root,int childs[]) {
        if(root == null)
            return 0;
        int result = 1;
//        for (int i= 0;i<root.children.size();i++){
//            result += countFees(root.children.get(i),childs);
//            childs[] += root.children;
//        }
        return result + (childs[root.val]+1)/5 == 0 ? 1:result + (childs[root.val]+1)/5;
    }
}
