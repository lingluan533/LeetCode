package com.zms.java.weizhong;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/9/13 20:36
 */
public class main02 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            long a = scan.nextLong();
            long b = scan.nextLong();
            int count = 0;
            Queue<Long> q = new ArrayDeque<>();
            q.add(a);

            HashSet<Long> set = new HashSet<>();
            set.add(a);
            boolean flag = false;
            while (!q.isEmpty()) {
                int curSize = q.size();
                count++;
                if (flag) break;
                while (curSize > 0) {
                    curSize--;
                    Long poll = q.poll();
                    if (poll == b) {
                        System.out.println(count - 1);
                        flag = true;
                        break;
                    }
                    //*2
                    Long poll2 = poll * 2;
                    if (!set.contains(poll2)) {
                        q.add(poll2);
                        set.add(poll2);
                    }
                    //*4
                    Long poll4 = poll * 4;
                    if (!set.contains(poll4)) {
                        q.add(poll4);
                        set.add(poll4);
                    }
                    //*8
                    Long poll8 = poll * 8;
                    if (!set.contains(poll8)) {
                        q.add(poll8);
                        set.add(poll8);
                    }
                    // /2
                    if (poll % 2 == 0) {
                        Long poll_2 = poll / 2;
                        if (!set.contains(poll_2)) {
                            q.add(poll_2);
                            set.add(poll_2);
                        }
                    }
                    // /4
                    if (poll % 4 == 0) {
                        Long poll_4 = poll / 4;
                        if (!set.contains(poll_4)) {
                            q.add(poll_4);
                            set.add(poll_4);
                        }
                    }
                    // /8
                    if (poll % 8 == 0) {
                        Long poll_8 = poll / 8;
                        if (!set.contains(poll_8)) {
                            q.add(poll_8);
                            set.add(poll_8);
                        }
                    }

                }
            }
            if (!flag) {
                System.out.println(-1);

            }
        }
    }
}
