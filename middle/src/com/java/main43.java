package com.java;

/**
 * @author: zms
 * @create: 2022/4/7 16:17
 */
public class main43 {
    public static void main(String[] args) {
        multiply("123456789","987654321");
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0") ) return "0";
        if(num1.equals("1")) return num2;
        if(num2.equals("1")) return num1;
        int len1 = num1.length();
        int len2 = num2.length();
        char [] num1s = num1.toCharArray();
        char [] num2s = num2.toCharArray();
        String res = "";
        for(int i = len2 - 1 ;i >= 0;i--){
            int cur = num2s[i] - '0';
            String curRes = "";
            int jinwei = 0;
            for(int j = len1 - 1;j>=0;j--){
                int curNums1 = (num1s[j]-'0');
                int product = cur * curNums1 + jinwei;
                jinwei = product / 10;
                int curleft = product % 10;
                curRes = curleft + curRes;
            }
            //如果最前面还有进位 则加上
            if(jinwei!=0){
                curRes = jinwei + curRes;
            }
            //在当前层的结果的后面填补上0(如果需要的话)
            for(int k = i;k<len2 - 1 ;k++){
                curRes +="0";
            }

            res = joinRes(res,curRes);

        }


        return res;
    }

    public static String joinRes(String res,String curRes){
            if(res == "0")return curRes;  //当前层的结果要长于之前的结果
            int jinwei  = 0;
            int lenres = res.length();
            int lencurres = curRes.length();
            if(lenres<lencurres){
                for(int i = 0;i<lencurres - lenres;i++){
                    res = "0" + res;
                }
            }
            String merges = "";

            for(int i = lencurres - 1;i>=0;i--){
                int curres =  res.charAt(i) - '0';
                int curcurRes = curRes.charAt(i) - '0';
                int add = curcurRes + curres + jinwei;
                jinwei = add / 10;
                int left = add % 10;
                merges = left + merges;
            }
            if(jinwei!=0){
                merges = jinwei + merges;
            }

            return merges;

    }
}
