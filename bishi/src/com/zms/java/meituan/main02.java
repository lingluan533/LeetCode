package com.zms.java.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/12 15:59
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        dfs(arr,0,n,arr[0],new ArrayList<Integer>());
        System.out.println(count);

    }
    static int count = 0;
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static void dfs(int[] arr, int begin,int len, int curval,ArrayList<Integer> list) {
       // if(begin == len) return ;
        for(int i =0;i<list.size();i++){
            System.out.print(list.get(i)+" " );

        }
        System.out.println();
        if(curval==1){
            count++;

            res.add(list);
        }

        for(int i = begin;i<len;i++){
          //  if(vis[i]) continue;

            curval = curval*arr[i];

            list.add(i);

            dfs(arr,i+1,len,curval,list);
            list.remove(list.size()-1);
            curval /= arr[i];

        }

    }
}
