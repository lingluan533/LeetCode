package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/4/5 21:15
 */
public class main863 {
    static HashMap<Integer , ArrayList<Integer>> hashMap;


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        List<Integer> list = distanceK(node1, node4, 3);
        Arrays.stream(list.toArray()).forEach(System.out::println);
    }


    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        hashMap = new HashMap<>();
        boolean vis[] = new boolean[501];
        dfs(root); //建树
        List<Integer> res = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque();
        queue.add(target.val);
        int curDis = 0;
        while(queue.isEmpty() == false){
           int curLen = queue.size();
            curDis ++ ;
            if(curDis == k+1){
                //距离等于k 则收集结果
                while (queue.isEmpty() == false){
                    res.add(queue.pop());
                }
                return res;
            }
            while(curLen > 0){
                Integer pop = queue.pop();
                curLen--;
                if(hashMap.get(pop)!= null){
                    for(int i = 0;i <hashMap.get(pop).size();i++){
                        if(hashMap.get(pop).get(i)!= target.val && vis[hashMap.get(pop).get(i)] == false)
                            queue.add(hashMap.get(pop).get(i));
                            vis[hashMap.get(pop).get(i)] = true;
                    }
                }

            }
        }
        return res;
    }

    private static void dfs(TreeNode root) {
        if(root == null) return ;
        if (root.left != null){
            if(   hashMap.containsKey(root.val)){
                hashMap.get(root.val).add(root.left.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.left.val);
                hashMap.put(root.val, list);
            }
            if(   hashMap.containsKey(root.left.val)){
                hashMap.get(root.left.val).add(root.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                hashMap.put(root.left.val, list);
            }
        }

        if (root.right != null){
            if(   hashMap.containsKey(root.val)){
                hashMap.get(root.val).add(root.right.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.right.val);
                hashMap.put(root.val, list);
            }
            if(   hashMap.containsKey(root.right.val)){
                hashMap.get(root.right.val).add(root.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                hashMap.put(root.right.val, list);
            }
        }
        dfs(root.left);
        dfs(root.right);
    }
}
