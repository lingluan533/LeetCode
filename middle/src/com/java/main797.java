package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/9/7 11:42
 */
public class main797 {
    List<List<Integer>> res;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.res = new ArrayList<>();
        int n = graph.length;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, path, graph, n);

        return res;
    }

    private void dfs(int cur, ArrayList<Integer> path, int[][] graph, int n) {
        if (cur == n - 1) {
            List<Integer> objects = new ArrayList<>(path);
            res.add(objects);
            return;
        }

        for (int i = 0; i < graph[cur].length; i++) {
            path.add(graph[cur][i]);
            dfs(graph[cur][i], path, graph, n);
            path.remove(path.size() - 1);
        }
    }

}
