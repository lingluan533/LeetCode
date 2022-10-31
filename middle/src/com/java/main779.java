package com.java;

/**
 * @author: zms
 * @create: 2022/10/20 9:22
 */
public class main779 {

    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if (k > (n >> 1)) {
            return 1 ^ kthGrammar(n - 1, k - (n >> 1));
        }
        return kthGrammar(n - 1, k);
    }

}
