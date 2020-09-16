package com.sh.study.exercise.six;

/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * @Author zhouwenchen
 * @Date  2020-09-16
 **/
public class MaximalSquare {

    /**
     * 暴力解法，从左上角到右下角的方式进行遍历操作
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        // 验证参数和合法性
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0){
            return 0;
        }
        // 计算行列值
        int m = matrix.length;
        int n = matrix[0].length;

        // 循环遍历
        int maxSide = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    // 遇到一个 1 作为正方形的左上角
                    maxSide = Math.max(maxSide, 1);
                    // 计算可能的最大正方形边长
                    int currentMaxSize = Math.min(m -i,n - j);
                    // 继续遍历 已当前 [i][j] 为左正方形的左上角的顶点，继续遍历获取
                    for(int k = 1; k < currentMaxSize;k++){
                        // 判断新增的一行一列是否为1
                        boolean flag = true;
                        // 判断右下角的是否是 ’0‘
                        if(matrix[i+k][j+k] == '0'){
                            break;
                        }
                        // 循环遍历，右变和下边的第 k位和p位是否为 ’0‘
                        for(int p = 0; p < k;p++){
                            if(matrix[i+k][j+p] == '0' || matrix[i+p][j+k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            maxSide = Math.max(maxSide,k+1);
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    /**
     * 动态规划
     *  dp(i,j) 表示以 (i, j)(i,j) 为右下角
     *   状态转移方程式： dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]) + 1; 加1 表示的是当前dp[i][j] 这个位置是1
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare1(char[][] matrix) {
        // 验证参数的合法性
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0|| j==0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
//        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquare1(matrix));
    }
}
