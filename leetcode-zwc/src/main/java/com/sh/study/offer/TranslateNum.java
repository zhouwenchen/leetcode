package com.sh.study.offer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * @author zhouwenchen
 * @date 2021/9/15 9:31
 **/
public class TranslateNum {
    /**
     *动态规划
     * f(i) = f(i - 1) + f(i - 2) 其中（x - 2 >= 0, 10 <= x <= 25）
     *
     * 初始条件是：
     * 有没有觉得很像是青蛙跳台阶的问题
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        if(arr.length <= 1){
            return 1;
        }
        int[] dp = new int[arr.length+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= arr.length; i++) {
            // 计算当前的只
            int n = (arr[i-2] - '0')* 10 + (arr[i-1] - '0');
            if(n >=10 && n <= 25){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[arr.length];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
