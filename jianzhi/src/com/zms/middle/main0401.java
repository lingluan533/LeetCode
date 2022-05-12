package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/2/15 0:15
 */
public class main0401 {
    public int numWays(int n) {
        if (n==0) return 1;
        if(n==1) return 1;
        if(n==2) return 2;
        int pre = 1;int cur = 2;
        for(int i =3;i<=n;i++){
            int tmp = cur;
            cur = (int) ((pre + tmp)%(1e9+7));
            pre = tmp;
        }
        return cur;
    }
}
