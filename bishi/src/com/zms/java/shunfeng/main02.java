package com.zms.java.shunfeng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int fa = scanner.nextInt();
            int to = scanner.nextInt();
            if (tree.containsKey(fa)) {
                tree.get(fa).add(to);
            } else {
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(to);
                tree.put(fa, objects);
            }
        }
        int numC[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            numC[i + 1] = i + 1;
        }
        T s = dfs(1, tree, numC);
        System.out.println(s.y - s.x);

    }

    static class T {
        long x;
        long y;

        public T(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static T dfs(int r, HashMap<Integer, ArrayList<Integer>> tree, int[] w) {
        if (tree.get(r) == null || tree.get(r).size() == 0) {
            if (w[r] > 0) {
                return new T(-1 * w[r], 0);
            } else {
                return new T(0, -1 * w[r]);
            }
        }
        T[] num = new T[tree.get(r).size()];
        long n1 = 0, n2 = 0;
        for (int i = 0; i < tree.get(r).size(); i++) {
            num[i] = dfs(tree.get(r).get(i), tree, w);
            n1 = Math.min(n1, num[i].x);
            n2 = Math.max(n2, num[i].y);
        }
        long val = w[r] + n1 + n2;
        if (val > 0) {
            n1 -= val;
        } else n2 -= val;
        return new T(n1, n2);
    }
}
