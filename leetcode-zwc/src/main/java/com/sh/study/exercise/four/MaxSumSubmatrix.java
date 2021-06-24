package com.sh.study.exercise.four;
import java.util.TreeSet;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 *
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 *
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 *
 *  https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/ju-xing-qu-yu-bu-chao-guo-k-de-zui-da-sh-70q2/
 *
 * @author zhouwenchen
 * @date 2021/4/22 9:46
 **/
public class MaxSumSubmatrix {

    /**
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++){
            int[] sum = new int[n];
            for (int j = i;j < m; ++j){
                for (int c = 0;c < n;++c){
                    sum[c] += matrix[j][c];
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v: sum){
                    s+=v;
                    Integer ceiling = sumSet.ceiling(s - k);
                    if(ceiling != null){
                        ans = Math.max(ans,s-ceiling);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }

    /**
     * TODO 这个好像有点问题
     * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/javacong-bao-li-kai-shi-you-hua-pei-tu-pei-zhu-shi/
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int maxSumSubmatrix1(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MAX_VALUE;
        for (int l = 0; l < cols;l++){ // 左边界
            // 左边界改变才重新算区域的开始
            int[] rowSum = new int[rows];
            for (int r = l; r < cols;r++){
                for (int i = 0; i < rows;i++){
                    rowSum[i] += matrix[i][r];
                }

                // 要求 rowSum 连续子数组的和 尽量最大，但不大于 k
                max = Math.max(max,dpmax(rowSum,k));
            }
        }
        return 0;
    }

    // 在数组中，求不超过 k 的最大值
    private static int dpmax(int[] arr, int k) {
        int rollSum = arr[0],rollMax = rollSum;
        for (int i = 1; i < arr.length;i++){
            if(rollSum > 0){
                rollSum += arr[i];
            }else {
                rollSum = arr[i];
            }
            rollMax = Math.max(rollMax,rollSum);
        }

        //
        if(rollMax <= k){
            return rollMax;
        }
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length;l++){
            int sum = 0;
            for (int r = l;r < arr.length;r++){
                sum += arr[r];
                if(sum > max && sum <= k){
                    max = sum;
                }
                if(max == k){
                    return k;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,0,1},
                {0,-2,3}
        };
        int k = 2;
        System.out.println(maxSumSubmatrix1(matrix, k));
    }
}
