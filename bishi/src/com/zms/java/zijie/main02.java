package com.zms.java.zijie;

import java.io.FileOutputStream;
import java.util.*;

/**
 * @author: zms
 * @create: 2022/8/28 9:50
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int N = scan.nextInt();
         scan.nextLine();
         int target[] = new int[0];
         int prereq[][] = new int[0][];
        ArrayList<int[]> list = new ArrayList<>();
         int num = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i= 0;i<N;i++){
            String text = scan.nextLine();
            String[] ts = text.split(" ");
            if (i==0){
                target = new int[ts.length];
                for (int j=0;j<ts.length;j++){
                    target[j] = Integer.parseInt(ts[j]);
                    set.add(Integer.parseInt(ts[j]));
                }
            }else{
                prereq = new int[ts.length-1][2];
                int to = Integer.parseInt(ts[0]);
                for (int j=1;j< ts.length;j++){
                    set.add(Integer.parseInt(ts[j]));
                    prereq[j-1] = new int[]{Integer.parseInt(ts[j]),to};
                    list.add(new int[]{Integer.parseInt(ts[j]),to} );
                }
            }
        }
        boolean adj[][] = new boolean[10][10];
        int rudu[] = new int[10];
        for (int i=0;i< list.size();i++){
          //  list.get(i)[0]
            adj[list.get(i)[0]][list.get(i)[1]] = true;
            rudu[list.get(i)[1]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<10;i++){
            if (rudu[i]==0 && set.contains(i)) pq.add(i);
        }

        HashSet<Integer> res = new HashSet<>();
        while (!pq.isEmpty()){
            int cur = pq.poll();
           res.add(cur);
            for (int i = 0;i<10;i++){
                if (adj[cur][i]){
                    rudu[i]--;
                    if (rudu[i]==0  && set.contains(i)) pq.add(i);
                }
            }
        }
        String rs = "";
      for (int i=0;i< target.length;i++){
          if (res.contains(target[i])){
             rs += 1+" ";
          }else{
              rs += 0+" ";
          }
      }
        System.out.print(rs.substring(0, rs.length() - 1));
    }
}
