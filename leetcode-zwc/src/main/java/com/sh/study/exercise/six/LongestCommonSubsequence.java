package com.sh.study.exercise.six;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 * @Author zhouwenchen
 * @Data 2020/9/14/10
 **/
public class LongestCommonSubsequence {
    /**
     * 使用动态规划实现
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 构建DP table 和 base case
        // dp[i][j] 表示： 字符串 str1[0:i] 和字符串 str2[0:j] 的最大公共子序列
        int[][] dp = new int[m+1][n+1];

        // 进行状态转移
        for (int i = 1; i <= m; i++){
            for (int j = 1;j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    // 这个字符存在于lcs中
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    // 此时 text1[i] != text2[j] 则表示至少有一个不在 lcs 中（要么 text1[i] 不在，要么 text2[j]不在，或者都不在）。
                    // 所以当前结果就相当于之前结果的中最大的那一个
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
