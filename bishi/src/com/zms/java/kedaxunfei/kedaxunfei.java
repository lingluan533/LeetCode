package com.zms.java.kedaxunfei;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author: zms
 * @create: 2022/8/20 19:27
 */
public class kedaxunfei {
    public static void main(String[] args) {
        System.out.println(seqSum(10));
    }
    public static float seqSum (int n) {
        float res = 0;
        if (n==1){
            res += 0.50;
            return (res);
        }
        double ress = 0;
        double cur = 0;
        double fenzi = 1.00;
        double fenmu = 2.00;
        for (float i = 1;i<=n;i++){
            if (i==1) {
                cur = 0.5F;
            }
              else cur = fenzi/fenmu;
              double temp = fenmu;
              fenmu = fenzi + fenmu;
              fenzi = temp;
           ress += cur;
        }
        BigDecimal bigDecimal = new BigDecimal(ress);

        DecimalFormat d = new DecimalFormat("0.00#");
        String format = d.format(ress);

        float v = (float)Math.round(ress*100)/100;
        v*=1.00;
        System.out.println(Math.round(ress * 100));
        return (float) (Math.round(ress*100))/100;

    }
}
