package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/9/7 21:37
 */
public class main498 {
    public static boolean check(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        int m = mat.length;
        int n = mat[0].length;
        HashSet<String> set = new HashSet<>();
        int res[] = new int[mat.length * mat[0].length];
        int count = 0;
        boolean flag = false;
        while (q.isEmpty() == false) {
            int cursize = q.size();

            Stack<Integer> s = new Stack<>();
            int tcursize = cursize;
            while (cursize > 0) {
                int[] t = q.poll();
                int x = t[0], y = t[1];
                int newx = x;
                int newy = y + 1;
                if (check(newx, newy, m, n) && !set.contains(String.valueOf(newx) + String.valueOf(newy))) {
                    q.add(new int[]{newx, newy});
                    set.add(String.valueOf(newx) + String.valueOf(newy));
                }
                newx = x + 1;
                newy = y;
                if (check(newx, newy, m, n) && !set.contains(String.valueOf(newx) + String.valueOf(newy))) {
                    q.add(new int[]{newx, newy});
                    set.add(String.valueOf(newx) + String.valueOf(newy));
                }
                cursize--;
                if (flag) {
                    res[count++] = mat[x][y];
                } else {
                    s.push(mat[x][y]);
                }

            }

            if (!flag) {
                while (s.isEmpty() == false) {
                    res[count++] = s.pop();
                }
            }
            flag = !flag;
        }
        return res;
    }
}

