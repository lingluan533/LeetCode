package com.java;

import java.util.List;

/**
 * @author: zms
 * @create: 2022/8/30 16:06
 */
public class main13904 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len];    // 截止到i，能否被字典中表示   返回值即为整个的字符串是否能被字典表示
        dp[0] = true;
        int maxLen = 0;
        for (String s1 : wordDict){
            maxLen = Integer.max(maxLen,s1.length());
        }
        for (int i = 1;i<=len;i++){
            ////剪枝操作：如果i的位置大于了最大单词的长度，那么j的起始位置应该在 i减去最大长度的位置开始，因若不然s.substring(j,i)的长度是大于最大单词的 长度的，所以一定不可能匹配成功。
            for (int j = (i<maxLen?0:i-maxLen);j<i;j++){
                if (dp[j] && wordDict.contains(s.substring(j,i))){ // 如果i之前某个点[0~j]能被字典表示，并且(j~i]之间的串能被字典包含 那么[0-i]就能被字典表示
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
