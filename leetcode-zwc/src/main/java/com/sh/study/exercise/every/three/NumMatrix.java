package com.sh.study.exercise.every.three;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class NumMatrix {
/*    int[][] sums;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m > 0){
            int n = matrix[0].length;
            sums = new int[m][n+1];
            // 二维数组求和
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    sums[i][j+1] = sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1;i <= row2;i++){
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }*/

    int[][] sums;
    /**
     * 使用动态规划实现
     * @param matrix
     */
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m > 0){
            int n = matrix[0].length;
            sums = new int[m+1][n+1];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] + sums[row1][col1] - sums[row1][col2+1] - sums[row2+1][col1];
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numArray = new NumMatrix(matrix);
        System.out.println(numArray.sumRegion(2, 1, 4, 3));
    }
}
