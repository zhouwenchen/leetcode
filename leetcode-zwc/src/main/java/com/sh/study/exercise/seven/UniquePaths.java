package com.sh.study.exercise.seven;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author zhouwenchen
 * @Date  2020-09-28
 **/
public class UniquePaths {
    /**
     * 动态规划规划
     *                  base case int[] dp = new int[m][n];
     * 状态转移方程式：    i > 0 且 j > 0 :dp[i][j] = dp[i-1][j] + dp[i][j-1];
     *                  i = 0 : dp[0][j] = 1 ;
     *                  j = 0 : dp[i][0] = 1moveZeroes
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        // 设置基本条件
        int[][] dp = new int[m][n];
        // 初始化条件操作
        for(int i = 0; i < m ; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n;j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
               dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 不同路径，使用动态规划
     * 假设i行和j列 当 i = 0,dp[0][j] = 1,当 j = 0，dp[i][0] = 1;
     * 当 i > 0 且 j > 0,dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * @date 202012090944
     * TODO 可以将三个循环写在一起的
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        // 当i = 0
        for (int j = 0; j < n;j++){
            dp[0][j] = 1;
        }
        // 当 j = 0
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
       return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths1(7, 3));
    }
}
