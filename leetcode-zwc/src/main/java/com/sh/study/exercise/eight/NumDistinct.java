package com.sh.study.exercise.eight;

/**
 * 115. 不同的子序列
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "rabbbit", T = "rabbit"
 * 输出：3
 * 解释：
 *
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2：
 *
 * 输入：S = "babgbag", T = "bag"
 * 输出：5
 * 解释：
 *
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * @Author zhouwenchen
 * @Date  2020-10-09
 **/
public class NumDistinct {
    /**
     * 动态规划：
     * base case : 初始化 t[i]  s[j] ,
     * dp[i][j]: 表示 t前 i 个字符串可以由 S 和 T 组成最多的个数

     * 状态转移方程式
     * 当 i = 0 时：dp[0][j] = 1
     * 当 j = 0 时：dp[i][0] = 0;
     * s[j] == t[i] dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
     * s[j] != t[i] dp[i][j] = dp[i][j-1];
     *
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t) {
        int m = t.toCharArray().length;
        int n = s.toCharArray().length;
        // 定义动态规划操作
        int[][] dp = new int[m+1][n+1];
        // base case 动态规划数组值
//        for(int i = 1; i < n; i++){
//            dp[i][0] = 0;
//        }
        for(int j = 0; j < n + 1; j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(numDistinct(s, t));
    }
}
