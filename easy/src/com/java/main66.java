package com.java;

/**
 * @author: zms
 * @create: 2022/1/9 0:45
 */
public class main66 {
    public int[] plusOne(int[] digits) {
        int flag = 0;
        int cur = 0;
        for(int i = digits.length-1; i>=0;i--){
            if(i==  digits.length -1 && digits[i] <9){
                digits[i] +=1;
                return digits;
            }
            else if(i== digits.length-1 && digits[i]==9){
                flag = 1;
                digits[i] = 0;
                continue;
            }
            cur = flag + digits[i] ;
            if(cur <10){
                digits[i] = cur;
                flag = 0;
                return digits;
            }else{
                digits[i] = 0;
                continue;
            }
        }
        int []res = new int [digits.length+1];
        if(flag == 1){
            res[0] = 1;
            System.arraycopy(digits,0,res,1,digits.length);
            return res;
        }

return  digits;

    }


}
