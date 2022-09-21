package com.zms.java.yongyou;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/9 19:21
 */
public class main02 {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
//        while (scan.hasNextLine()) {
//            String s = scan.nextLine();
//            list.add(s);
//
//        }
        for (int i = 0; i < 8; i++) {
            String s = scan.nextLine();
            list.add(s);
        }
        int col = list.get(0).split(",").length;
        int row = list.size();
        int a[][] = new int[row][col];
        for (int i = 0; i < list.size(); i++) {
            String t[] = list.get(i).split(",");
            for (int j = 0; j < col; j++) {
                a[i][j] = Integer.parseInt(t[j]);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 1) {
                    boolean[][] booleans = new boolean[row][col];
                    booleans[i][j] = true;
                    dfs(a, i, j, 1, booleans, row, col);
                }
            }
        }
        System.out.println(max);


    }

    static int flag[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void dfs(int[][] a, int x, int y, int count, boolean[][] vis, int row, int col) {

        for (int i = 0; i < 4; i++) {
            int newX = x + flag[i][0];
            int newY = y + flag[i][1];
            if (!(newX >= 0 && newX < row && newY >= 0 && newY < col && !vis[newX][newY] && a[newX][newY] == 1)) {
                continue;
            }
            vis[newX][newY] = true;
            count++;
            max = Math.max(max, count);
            dfs(a, newX, newY, count, vis, row, col);
            //vis[newX][newY] = false;
            //count--;

        }
        max = Math.max(max, count);
    }
}
