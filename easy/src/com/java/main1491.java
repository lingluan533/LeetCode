package com.java;

/**
 * @author: zms
 * @create: 2022/1/2 21:45
 */
public class main1491 {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len  = salary.length;
        double sum = 0;
        for(int i =0;i<len ;i++){
            sum+=salary[i];
            max= Math.max(max,salary[i]);
            min = Math.min(min,salary[i]);
        }
        sum-=(max + min);
       //* double res =  sum / (len-2);



       return  sum / (len-2);

    }
}
