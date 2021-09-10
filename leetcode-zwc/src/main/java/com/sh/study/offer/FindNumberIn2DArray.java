package com.sh.study.offer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * @author zhouwenchen
 * @date 2021/9/10 15:01
 **/
public class FindNumberIn2DArray {

    /**
     * 先从左向右遍历
     * 之后从上向下遍历
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
       if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
           return false;
       }
       int rows = matrix.length;
       int colums = matrix[0].length;
       int row = 0,column = colums - 1;
       while (row  < rows && column >= 0){
           int num = matrix[row][column];
           if(target == num){
               return true;
           } else if(num > target){
               column--;
           }else {
               row++;
           }

       }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(findNumberIn2DArray(matrix, target));
    }
}
