package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/8/13 16:37
 */
public class main10205 {
    public List<List<Integer>> levelOrder(TreeNode root){
        Deque<TreeNode> pq = new ArrayDeque<>();
        pq.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = pq.size();
           for(int i = 0;i<len;i++){
               TreeNode poll = pq.poll();
               temp.add(poll.val);
               if (poll.left!=null) pq.add(poll.left);
               if(poll.right!=null) pq.add(poll.right);
           }
           res.add(temp);
        }
        return res;
    }
}
