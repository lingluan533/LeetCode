package com.java.yuanfudao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/26 19:49
 */
public class main02 {
    public static boolean isP(int x){
        boolean s = true;
        for (int i=2;i<=Math.sqrt(x);i++){
            if (x%i==0){
                s = false;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        for (int i = 0;i<M;i++){
            int K = scan.nextInt();
            int N = scan.nextInt();
            int ary [] = new int[N];
            for (int j = 0;j<N;j++){
                ary[j] = scan.nextInt();
            }
            int ans = 1;
            ArrayList<Integer> zhi = new ArrayList<>();
            if (isP(K)){
                zhi.add(K);
            }else{
                for (int k=2;k*k<=K;k++){
                    if (isP(k)){
                        while (K%k==0){
                            zhi.add(k);
                            K/=k;
                            if(isP(K)){
                                zhi.add(K);
                                break;
                            }
                        }
                    }
                }
            }
            if (zhi.size()==1){
                boolean flag = false;
                for (int s=0;s<N-zhi.size();s++){
                    if (zhi.contains(ary[s])){
                        System.out.println(1);
                        flag = true;
                        break;
                    }
                }
                continue;
            }
            int cur = 0;
            int start = 0;
            int min =Integer.MAX_VALUE;
            for (int s=0;s<N-zhi.size();s++){
                if (zhi.contains(ary[s])){//开启寻找
                    start = s;

                    ArrayList<Integer> t = new ArrayList<>(zhi);
                   int index=  t.indexOf(ary[s]);
                   t.remove(index);
                    int ss = s+1;
                    while (ss<N){
                        if (t.contains(ary[ss])){
                             index =  t.indexOf(ary[ss]);
                            t.remove(index);
                            if (t.size()==0){
                                min = Math.min(min,ss-start+1);
                                break;
                            }
                        }
                        ss++;
                    }
                }
            }
            if (min==Integer.MAX_VALUE){
                System.out.println(0);

            }else{
                System.out.println(min);
            }
        }
    }
}
