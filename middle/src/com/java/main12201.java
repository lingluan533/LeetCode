package com.java;

/**
 * @author: zms
 * @create: 2022/9/7 11:13
 */
public class main12201 {
    public int maxProfit(int[] prices) {
        int noHold = 0;
        int hold = -1 * prices[0];
        for (int i = 1; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i]); // 今天结束不持有 --》 昨天也不持有，或者昨天持有今天卖掉的最大者
            hold = Math.max(noHold - prices[i], hold); // 今天结束持有 --》 昨天不持有，今天才买 或者 昨天就持有 的较大者
        }
        return noHold;
    }
}
