package com.zms.java.ali;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/4 20:52
 */
public class main01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int  T  = scan.nextInt();
        for(int i = 0;i<T;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            String preStr = "";
            String nextStr = "";
            while(y>0){
                int next = x+1;
                preStr = x +"";
                nextStr = next + "";
                if(nextStr.length() - 1 == preStr.length()){
                    preStr = "0"+preStr;
                }
                int curLife = 0;
                for(int j = 0;j<preStr.length();j++){
                    if(preStr.charAt(j)!=nextStr.charAt(j)){
                        curLife ++;
                    }
                }
                if(y > curLife){
                    y-=curLife;
                    x+=1;
                    continue;
                }else if(curLife == y ){
                    System.out.println(next);//结束
                    break;
                }else{
                    System.out.println(x);
                    break;
                }
            }
        }
    }
}
