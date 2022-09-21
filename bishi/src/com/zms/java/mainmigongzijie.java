package com.zms.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/27 14:41
 */
public class mainmigongzijie {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N,M;
        N = scan.nextInt();
        M = scan.nextInt();
        scan.nextLine();
        int endr =0, endc=0;
        char [][] cs = new char[N][M];
        for (int i = 0;i<N;i++){
            String s = scan.nextLine();
            for (int j = 0;j<M;j++){
                cs[i][j] = s.charAt(j);
                if (cs[i][j] == 'O'){
                    endr = i;
                    endc = j;
                }
            }
        }
        boolean vis[][] = new boolean[N][M];
        vis[endr][endc] = true;
        Deque<int[]> queue = new ArrayDeque();
        queue.add(new int[]{endr,endc});
        int flag[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                size--;
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                // 上
                if (x-1>=0 && !vis[x-1][y] && (cs[x-1][y]=='.'||cs[x-1][y]=='D')){ // 符合条件，且没有入队过才加入队列
                    queue.add(new int[]{x-1,y});
                    vis[x-1][y] = true;
                }
                // 下
                if(x+1<N&&!vis[x+1][y]&&(cs[x+1][y] == '.' || cs[x+1][y] == 'U')){
                    queue.add(new int[]{x+1,y});
                    vis[x+1][y] = true;
                }
                // 左
                if(y-1>=0&&!vis[x][y-1]&&(cs[x][y-1] == '.' || cs[x][y-1] == 'R')){
                    queue.add(new int[]{x,y-1});
                    vis[x][y-1] = true;
                }
                // 右
                if(y+1<M&&!vis[x][y+1]&&(cs[x][y+1] == '.' || cs[x][y+1] == 'L')) {
                    queue.add(new int[]{x, y + 1});
                    vis[x][y + 1] = true;
                }

            }
        }
        int res = 0;
        for(int i = 0;i<N;i++){
            for (int j = 0;j<M;j++){
                if (vis[i][j]==false){
                    res++;
                }
            }
        }
        System.out.println(res);
    }

}
