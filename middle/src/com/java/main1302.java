package com.java;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

/**
 * @author: zms
 * @create: 2022/8/17 21:26
 */
public class main1302 {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()){
            int curSize = queue.size();
            sum = 0;
            while (curSize>0){
                sum+=queue.peek().val;
                TreeNode node = queue.peek();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                curSize--;
            }
        }

        return sum;
    }
}
