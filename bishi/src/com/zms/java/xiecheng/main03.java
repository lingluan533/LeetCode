package com.zms.java.xiecheng;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/8/30 19:47
 */
public class main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String color = scan.nextLine();
        char[] colorMap = new char[n+1];
        for (int i = 0;i<n;i++){
            colorMap[i+1] = color.charAt(i);
        }
        HashMap<Integer,List<Integer>> connect = new HashMap();
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0;i<n-1;i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            list.add(new int[]{u,v});
            boolean b = connect.containsKey(u);
            if (!b){
               List<Integer> lu =  new ArrayList<>();
               lu.add(v);
               connect.put(u,lu);
            }else{
                connect.get(u).add(v);
            }

            boolean b1 = connect.containsKey(v);
            if (!b1){
                List<Integer> lu =  new ArrayList<>();
                lu.add(u);
                connect.put(v,lu);
            }else{
                connect.get(v).add(u);
            }


        }
        int count = 0;
        for(int i = 0;i<n-1;i++){
            int x = list.get(i)[0];int y = list.get(i)[1];
            connect.get(x).remove((Integer)y);
            connect.get(y).remove((Integer)x);
           if( getColorNum(connect,list.get(i)[0],list.get(i)[1],colorMap)&& getColorNum(connect,list.get(i)[1],list.get(i)[0],colorMap)){
               count++;
           }
            connect.get(x).add((Integer)y);
            connect.get(y).add((Integer)x);
        }
        System.out.println(count);

    }

    private static boolean getColorNum( HashMap<Integer,List<Integer>> connect,int u,int v,char [] colors) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(u);
        boolean vis[]= new boolean[colors.length+1];
        int n = colors.length;
        vis[u] = true;
        boolean r=false,g = false,b=false;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            vis[poll] = true;

            if (colors[poll]=='r') r=true;
            if (colors[poll]=='g') g=true;
            if (colors[poll]=='b') b=true;
            if (r&&g&&b) return true;
            for (int i = 1;i<n;i++){
                if (!vis[i] && connect.get(poll).contains(i)){
                    queue.add(i);
                }
            }
        }
        return false;
    }
}
