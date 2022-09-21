package com.zms.java.wangyi1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/9/4 15:45
 */
public class main04 {

    static boolean tongyi[];
    static int colors[];
    static int wnum;
    static int paintnum;
    static boolean first = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        int n = scan.nextInt();
        wnum = w;
        paintnum = n;
        int ary[] = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = scan.nextInt();
        }
        tongyi = new boolean[w];
        colors = new int[w];
        Arrays.fill(tongyi, true);
        Arrays.fill(colors, -1);
        int paint[] = new int[w];
        Arrays.fill(paint, -1);
        dfs(0, 0, ary, paint);

        int count = 0;
        for (int i = 0; i < wnum; i++) {
            if (tongyi[i] && colors[i] != -1) {
                count++;
            }
        }
        System.out.println(count);
        for (int i = 0; i < wnum; i++) {
            if (tongyi[i] && colors[i] != -1) {
                System.out.print((i + 1) + " ");
            }
        }
    }

    private static void dfs(int color, int next, int paintcount[], int paint[]) {
        if (color == paintnum) {
            if (first) {
                for (int i = 0; i < wnum; i++) {
                    if (paint[i] != -1) {
                        int j = i;
                        for (j = i; j < i + paintcount[paint[i]]; j++) {
                            colors[j] = paint[i];
                        }
                        i = j - 1;
                    }
                }
                first = false;
            } else {
                for (int i = 0; i < wnum; i++) {
                    if (paint[i] != -1) {
                        int j = i;
                        for (j = i; j < i + paintcount[paint[i]]; j++) {
                            if (tongyi[j] && paint[i] == colors[j]) continue;
                            else {
                                tongyi[j] = false;
                                colors[j] = -1;
                            }
                        }
                        i = j - 1;
                    } else {
                        if (tongyi[i] && colors[i] == -1) continue;
                        else {
                            tongyi[i] = false;
                            colors[i] = -1;
                        }
                    }
                }
            }

            System.out.println(Arrays.toString(colors));
            return;
        }
        for (int i = next; i < wnum; i++) {
            if (paintcount[color] + i - 1 < wnum) {
                paint[i] = color;
                int count = paintcount[color];
                color++;
                dfs(color, count + i + 1, paintcount, paint);
                color--;
                paint[i] = -1;
            }
        }
    }
}
