package com.sh.study.exercise.four;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * @Author zhouwenchen
 * @Data 2020/9/11/15
 **/
public class SearchMatrix {
    /**
     * 从右上或者左下进行判断
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int i = 0;
        int j = matrix[0].length -1;
        while (i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] > target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

    /**
     * 20210330
     * 遍历方式，从右上到左下
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        // 验证参数的有效性
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1 ;
        while (i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

    /**
     * 从左下到右上
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        // 验证参数
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int i = matrix.length-1;
        int j = 0;
        while (i >= 0 && j <= matrix[0].length-1){
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] > target){
                i--;
            }else {
                j++;
            }

        }
        return false;
    }


    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1,  3,  5,  7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50},
//        };
//        int target = 3;

//        int[][] matrix = new int[][]{
//        };
//        int target = 0;

        int[][] matrix = new int[][]{{1}};
        int target = 1;
        System.out.println(searchMatrix2(matrix, target));
    }
}
