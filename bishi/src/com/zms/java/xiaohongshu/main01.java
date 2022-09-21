package com.zms.java.xiaohongshu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/28 16:16
 */
public class main01 {
    static class Ren implements Comparable<Ren>{
        int id;
        int sum;
        public  Ren(int id,int sum){
            this.id = id;
            this.sum = sum;
        }
        @Override
        public int compareTo(Ren o) {
            if (this.sum==o.sum){
                return this.id - o.id;
            }else{
                return o.sum - this.sum;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int did = scanner.nextInt();
        ArrayList<Ren> list = new ArrayList<>();
        for (int i = 0;i<n;i++){
            int sum = 0;
            for (int j=0;j<m;j++){
                sum += scanner.nextInt();
            }
            list.add(new Ren(i+1,sum));
        }
        Collections.sort(list);
        for (int i = 0;i<list.size();i++){
            if (list.get(i).id==did){
                System.out.println(i+1);
            }
        }
    }
}
