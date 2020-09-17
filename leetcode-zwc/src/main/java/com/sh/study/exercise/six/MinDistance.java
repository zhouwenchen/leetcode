package com.sh.study.exercise.six;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * @Author zhouwenchen
 * @Date  2020-09-17
 **/
public class MinDistance {

    /**
     * 思路：动态规划
     *   字符串  A，字符串 B，从考试进行比较，如果  word1[0][0] == word2[0][0]; 则 i++,j++
     *   如果不相等的话，那么，就有三种解决方案，
     *   （1）：某一个增加一个字符，
     *   （2）：某一个删除一个字符，
     *   （3）：某一个替换一个字符
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // base case
        for(int i = 1; i <= m ; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= n; j++){
            dp[0][j] = j;
        }

        // 动态规划的状态转移方程式
        for(int i = 1; i <=m ;i++){
            for(int j = 1; j <=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + 1,Math.min(dp[i][j-1] + 1,dp[i-1][j-1] + 1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "inention";
        System.out.println(minDistance(word1, word2));
    }
}
