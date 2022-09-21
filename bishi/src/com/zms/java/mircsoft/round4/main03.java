package com.zms.java.mircsoft.round4;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/8/25 19:45
 */
public class main03 {
    public static void main(String[] args) {
        int a[] = new int[10000];
        Arrays.fill(a,2);
        System.out.println(solution(a));
       // System.out.println(solution(new int[]{7,7,7,7}));
     //   System.out.println(solution(new int[]{-1,1,3,3,3,2,3,2,1,0}));
    }
    public static  int solution(int[] A) {
        int len = A.length;
        int start = 0;
        int cha = 0;
        int count = 0;
        for (int i = 0;i<len-2;i++){
            cha = A[i+1]-A[i];
            start = i;
            while (i+1<len && A[i+1]-A[i]==cha){
                i++;
            }
            count += countC(i-start+1);
            if (count>=1000000000) return -1;
            i -=1;
        }
        return count;

    }

    private static int countC(int i) {
        if (i==3) return 1;
        return i-2+(i-2)*(i-3)/2;
    }
}
