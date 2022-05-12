package com.java;

/**
 * @author: zms
 * @create: 2021/12/31 9:00
 */
public class main507 {
    public boolean checkPerfectNumber(int num) {
       int ans = 0;
       for(int i = 1;i<Math.sqrt(num);i++){
           if(num % i == 0){
               ans += i;
           }
           if(ans > num ) return false;
       }


        return   ans == num ? true:false;
    }
}
