package com.zms.java.ali;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/5 21:25
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int  T  = scan.nextInt();
        for(int i = 0;i<T;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(y>=1)
            while(y > 1){
                int countlen = (y+"").length();

                int cur1 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0;j<countlen;j++){
                    stringBuilder.append("1");
                }
                cur1 = Integer.parseInt(stringBuilder.toString());
                //判断大还是小
                if(y > cur1){ //y大
                    x += (y / cur1) *Math.pow(10,countlen-1);
                    y = (int) (y- (y / cur1) *Math.pow(10,countlen-1));
                }else if(y == cur1){
                    x += (y / cur1) *Math.pow(10,countlen-1);
                    System.out.println(x);
                    break;
                }
                else{//y小
                     x += 9*Math.pow(10,countlen-2);
                     y = (int) (y - 9 *Math.pow(10,countlen-2));
                }
            }
            if(y==1){
                int len = (x+"").length();
                if((x+"").charAt(len-1)=='9') System.out.println(x);
                else{
                    System.out.println(x+1);
                }
            }
        }


    }
}
