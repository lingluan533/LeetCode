package com.zms.java.baidu01;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/13 19:22
 */
public class main03 {
    static class Node {
        int x;
        int y;

        public Node(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();
        char a[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextLine().toCharArray();
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0));
        HashSet<String> set = new HashSet<>();
        set.add(0 + "" + 0 + "");
        int count = 0;
        int[][] flag = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int curSize = q.size();
            count++;
            while (curSize > 0) {
                Node poll = q.poll();
                set.add(poll.x + "" + poll.y + "");
                curSize--;
                for (int i = 0; i < 4; i++) {
                    int newX = poll.x + flag[i][0];
                    int newY = poll.y + flag[i][1];
                    if (!(newX >= 0 && newX < n && newY >= 0 && newY < m)) {
                        continue;
                    }
                    switch (a[poll.x][poll.y]) {
                        case 'r':
                            if (a[newX][newY] == 'd') {
                                continue;
                            }
                            break;
                        case 'e':
                            if (a[newX][newY] == 'r') {
                                continue;
                            }
                            break;
                        case 'd':
                            if (a[newX][newY] == 'e') {
                                continue;
                            }
                            break;

                    }
                    if (set.contains(newX + "" + newY + "")) {
                        continue;
                    }
                    if (newX == n - 1 && newY == m - 1) {
                        System.out.println(count);
                        return;
                    }
                    q.add(new Node(newX, newY));
                }
            }
        }
        System.out.println(-1);

    }
}
