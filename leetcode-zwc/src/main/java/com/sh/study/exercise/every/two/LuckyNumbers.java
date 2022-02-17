package com.sh.study.exercise.every.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1380. 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 * @author zhouwenchen
 * @date 2022/2/15 15:04
 **/
public class LuckyNumbers {

    public static List<Integer> luckyNumbers (int[][] matrix) {
        // 先获取到每行的最小值
        // 行号和列号
        int m = matrix.length;
        int n = matrix[0].length;
        // 获取每行的最小值,和索引位置，然后判断是否是每列的最大值
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++){
            int j = 0;
            int min = Integer.MAX_VALUE;
            int index = 0;
            int[] arr = matrix[i];
            for (; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            map.put(min,index);
        }

        // 判断是否是当前列的最大值
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer min = entry.getKey();
            Integer index = entry.getValue();
            int flag = 0;
            for (int i = 0; i < m; i++){
                if(min < matrix[i][index]){
                    flag = 1;
                    break;
                }
            }
            if(flag ==1){
                continue;
            }
            res.add(min);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {3, 7, 8},
//                {9, 11, 13},
//                {15, 16, 17}
//        };
//        int[][] matrix = {
//                {7,8},
//                {1,2}
//        };
        int[][] matrix = {
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };
        luckyNumbers(matrix).stream().forEach(System.out::println);
    }
}
