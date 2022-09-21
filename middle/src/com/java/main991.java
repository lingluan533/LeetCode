package com.java;

/**
 * @author: zms
 * @create: 2022/8/22 12:07
 */
public class main991 {
    public int brokenCalc(int startValue, int target) {
        int step = 0;
        // target +1 或者 /2 来接近startValue
        while (target!=startValue){
            if (startValue-1==target) {
                step++;
                return step;
            }
            if(target%2==0){
                if(target > startValue){
                    target/=2;
                    step++;
                }else{
                    target+=1;
                    step++;
                }

            }else{
                target+=1;
                step++;
            }
        }
        return step;
    }
}
