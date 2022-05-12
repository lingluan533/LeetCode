package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/1/2 11:07
 */
public class main5969 {
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int len = asteroids.length;
        Arrays.sort(asteroids);

        for(int i =0;i<len;i++){
            if(mass < asteroids[i]){
                return false;
            }
            mass += asteroids[i];
            if(mass > asteroids[len-1]) return true;
        }

        return true;
    }

    public static void main(String[] args) {
//
}}
