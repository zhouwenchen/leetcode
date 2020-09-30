package com.sh.study.exercise.eight;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * @Author zhouwenchen
 * @Date  2020-09-30
 **/
public class UniquePathsWithObstacles {

    /**
     * 动态规划 int[][] dp = new int[][];
     * 当 i = 0,j >= 0 时 dp[0][j] = 1
     * 当 i >= 0,j = 0 时 dp[i][0] = 1
     * 当 i > 0, j > 0 时 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * 以上的状态转移方程式，是在没有障碍物的情况下，如果此时有障碍物的情况下的话，就不是这样的方程式
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // base case
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i< m; i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }
        for(int j = 0; j< n; j++){
            if(obstacleGrid[0][j] == 1){
                dp[0][j] = 0;
               break;
            }
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }; // 2

//        [[1,0]]
//        int[][] obstacleGrid = new int[][]{
//                {1,0}
//        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
