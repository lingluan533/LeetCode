package com.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: zms
 * @create: 2022/1/11 0:05
 */
public class main406 {
    public static void main(String[] args) {
        int[][] people = new int[6][2];
        people[0] = new int[]{7,0};
        people[1] = new int[]{4,4};
        people[2] = new int[]{7,1};
        people[3] = new int[]{5,0};
        people[4] = new int[]{6,1};
        people[5] = new int[]{5,2};
        int [][] res = reconstructQueue(people);
        for(int i =0;i<6;i++){
            for(int j = 0;j<2;j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
    public static  int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> {
            if(o1[1] != o2[1]){
                return o1[1] - o2[1];
            }else {
                return o1[0] - o2[0];
            }
        });
        for(int i = 0;i< people.length;i++){
            int prebiggercount = check(i,people);
            if(prebiggercount == people[i][1]){
                continue;
            }else{
                while(prebiggercount > people[i][1]){
                    prebiggercount --;
                    int [] tem = people[i];
                    people[i] = people[i-1];
                    people[i-1] = tem;
                    i--;
                }
            }
        }


        return people;
    }

    private static int  check(int i, int[][] people) {
        if(people[i][1] ==0 ) return 0;
        int count = 0;
        for(int j = 0;j<i;j++){
            if(people[j][0] >= people[i][0] ){
                count ++;
            }
        }
        return count;

    }
}
