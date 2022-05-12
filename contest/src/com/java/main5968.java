package com.java;

/**
 * @author: zms
 * @create: 2022/1/2 10:51
 */
public class main5968 {
    public static int numberOfBeams(String[] bank) {
        int m = bank.length;
        String cur = "";
        String tem ="";
        int ans =0;

        for (int i =0;i<m;i++){
            cur = bank[i];
            if(!cur.contains("1")) continue;
            for(int j=i+1;j<m;j++){
                tem = bank[j];
                if(!tem.contains("1")) continue;

                int curcount = 0,tempcount=0;
                for(Character c : cur.toCharArray()){
                    if(c=='1') curcount ++;
                }
                for(Character c : tem.toCharArray()){
                    if(c=='1') tempcount++;
                }
                ans += tempcount*curcount;
                        break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    numberOfBeams(new String[]{"011001","000000","010100","001000"});
    }
}
