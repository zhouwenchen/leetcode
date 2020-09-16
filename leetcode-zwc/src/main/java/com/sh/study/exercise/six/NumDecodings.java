package com.sh.study.exercise.six;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
 *
 * @Author zhouwenchen
 * @Date  2020-09-16
 **/
public class NumDecodings {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }

        /**
         *   // dp[i] 以 s[i - 1] 结尾的前缀子串有多少种解法方法
         *   // dp[i] = dp[i - 1] * 1 if nums[i - 1] != '0'
         *   // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 2..i - 1]) <= 26
         */
        int[] dp = new int[len + 1];
        dp[0] = 1;
        char[] charArray = s.toCharArray();
        if(charArray[0] == '0'){
            return 0;
        }
        dp[1] = 1;

        for(int i = 1; i < len;i++){
            if(charArray[i] != '0'){
                dp[i+1] = dp[i];
            }

            int num = 10 * (charArray[i-1] - '0') + (charArray[i] - '0');
            if(num >= 10 && num <=26){
                dp[i+1] += dp[i-1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
//        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("12"));
    }
}
