package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/10/19 11:30
 */
public class main4705 {
    static List<List<Integer>> res;
    static int[] nums;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permuteUnique(new int[]{1, 1, 2}).toArray()));
    }

    public static List<List<Integer>> permuteUnique(int[] num) {
        nums = num;
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(new boolean[num.length], new ArrayList<Integer>());
        return res;
    }

    private static void dfs(boolean[] vis, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            System.out.println(Arrays.toString(path.toArray()));
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;  // 在这个树枝下，当前节点已经被加入了 就不能重复加入了 保证节点只加入一次序列
            if (i > 0 && !vis[i - 1] && nums[i - 1] == nums[i])
                continue; // 去重 两个紧挨着的1 1 ，在第一个1已经作为前面数据的序列之后，不让第二个1再做前面数据的序列了 ，去重
            vis[i] = true;
            path.add(nums[i]);
            dfs(vis, path);
            vis[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
