package com.java;

/**
 * @author: zms
 * @create: 2022/8/10 20:10
 */
public class main640 {
    public static void main(String[] args) {
        solveEquation("x+5-3+x=6+x-2");
    }
    public static String solveEquation(String equation) {
        // equation = "x+5-3+x=6+x-2"
        char cs [] = equation.toCharArray();
        int x = 0 , sum = 0;
        int len = equation.length();
        int op = 1;
        for (int i = 0; i<len ;i++ ){
            if (cs[i]=='+'){
                op = 1;
            }else if (cs[i]=='-'){
                op = 0;
            }else if(cs[i]=='='){
                op = 1;
                sum *=-1;
                x*=-1;
            } else {
                int cur = i;
                while(i<len && cs[i]!='+'&&cs[i]!='-'&&cs[i]!='='){
                    i++;
                }
                if(cs[i-1]=='x'){
                    if (op==1)
                   x+= cur == i-1? 1: Integer.parseInt(equation.substring(cur,i-1));
                    else x -=cur == i-1? 1:Integer.parseInt(equation.substring(cur,i-1));
                }else{
                    if (op==1)
                        sum += Integer.parseInt(equation.substring(cur,i));
                    else sum -= Integer.parseInt(equation.substring(cur,i));
                }
                i--;
            }
        }
        if (x==0){
            return sum == 0 ? "Infinite solutions":"No solution";
        }else{
            return "x="+((-1*sum)/x);
        }
    }
}
