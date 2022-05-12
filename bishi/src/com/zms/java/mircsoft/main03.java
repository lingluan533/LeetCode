package com.zms.java.mircsoft;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: zms
 * @create: 2022/1/23 17:06
 */
public class main03 {
    public int solution(Integer[] H, int X, int Y) {
        X = Math.max(X,Y);
        Arrays.sort(H);
        boolean visited[] = new boolean[H.length];
        int count=0;
        for(int i = H.length-1;i>=0;i--){
            if(visited[i] == false && H[i] <= X) {
                visited[i] = true;
                X -= H[i];
                count++;
            }
        }
        for(int j =  H.length-1;j>=0;j--){
            if(visited[j] == false && H[j] <= Y){
                visited[j] = true;
                Y -= H[j];
                count ++;
            }
        }


       return count;
    }
}
