package com.sh.study.exercise.nine;

/**
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 * @Author zhouwenchen
 * @Data 2020/10/29/16
 **/
public class MaximalRectangle {
    /**
     * 思路1：遍历二叉数组
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] width = new int[m][n];

        int maxArea = 0;

        // 遍历每一行
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                // 更新 width
                if(matrix[i][j] == '1'){
                    if(j == 0){
                        width[i][j] = 1;
                    } else {
                        width[i][j] = width[i][j-1] + 1;
                    }
                } else{
                    width[i][j] = 0;
                }

                // 记录所有行中的最小值
                int minWidth = width[i][j];
                // 向上扩展行
                for (int up_row = i; up_row >=0; up_row--){
                    int height = i - up_row + 1;
                    // 找到最小的数作为矩阵的宽
                    minWidth = Math.min(minWidth, width[up_row][j]);
                    // 更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
