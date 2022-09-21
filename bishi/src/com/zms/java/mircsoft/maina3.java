package com.zms.java.mircsoft;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/8/19 19:01
 */
public class maina3 {
    public static void main(String[] args) {
        solution(new int[]{2,4,2,6,7,1},new int[]{0,5,3,2,1,5},2);
    }
    public static int solution(int[] X, int[] Y, int W) {
        Arrays.sort(X);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ;i < X.length; i++){
            if (list.contains(X[i]))continue;
            list.add(X[i]);
        }
        int left = list.get(0);
        int cur = 0;
        for (int i = 1;i<list.size();i++){
            if (list.get(i)-left<=W){
                continue;
            }else  {
                left = list.get(i);
                cur++;
            }
        }
        return cur+1;
    }
}
