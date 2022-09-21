package com.java;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/9/6 17:47
 */
public class mainerchashu {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3);
        node2.right = node3;
        node.left = node1;
        node.right = node2;
        System.out.println(getHigh(node));
        
        System.out.println(BigDecimal.valueOf(15).multiply(BigDecimal.valueOf(1.5), new MathContext(0, RoundingMode.UP)).setScale(0, RoundingMode.UP).intValue());

    }

    public static int getHigh(TreeNode node) {
        if (node == null) return 0;
        if (node.right == null && node.left == null) return 1;

        Queue<TreeNode> queue = new ArrayDeque<>();
        int height = 0;
        queue.add(node);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            height++;
            while (curSize > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                curSize--;
            }
        }
        return height;
    }
}
