package com.zms.java;

/**
 * @author: zms
 * @create: 2022/1/23 15:43
 */
public class test {
    public int solution(int[] A) {
        boolean visited[] = new boolean[1000000];

        for(int i = 0;i<A.length;i++){
            if(A[i] >0){
                visited[A[i]] = true;
            }
        }
        for(int i =1;i<1000000;i++){
            if(visited[i] == false)
                return i;
        }
        return 0;
    }
}
