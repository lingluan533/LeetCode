package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/10/25 9:57
 */
public class main78 {
    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    static List<List<Integer>> res;

    public static List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        res = new ArrayList<>();
        dfs(0, new ArrayList<Integer>(), nums);
        for (List<Integer> path : res) {
            for (Integer in : path) {
                System.out.print(in + " ");
            }
            System.out.println();
        }

        return res;
    }

    private static void dfs(int start, ArrayList<Integer> path, int[] nums) {
        for (Integer in : path) {
            System.out.print(in + " ");
        }
        System.out.println();


        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1, path, nums);
            path.remove(path.size() - 1);
        }
        res.add(new ArrayList<>(path));
    }
}
