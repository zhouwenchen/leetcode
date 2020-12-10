package com.sh.study.exercise.every;

/**
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/7 10:03
 */
public class MatrixScore {
    /**
     * 使用贪心算法
     * 先行转，如果第一位为0，那么就反转为1，
     * 现在保证了第一列都是1，之后判断之后的列，只要保证列  1的个数比 0 多，如果不多于，就直接反转实现
     * @param A
     * @return
     */
    public static int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        // 第一列都是1的情况
        int ret = m * (1 << (n-1));
        // 判断除第一列之外的，只要保证其他列1的数量比较多就行了，通过列来遍历
        for (int j = 1;j < n; j++){
            int one = 0;
            for (int i = 0; i < m; i++){
                if(A[i][0] == 1){
                    one += A[i][j];
                } else {
                    one += (1 - A[i][j]); // 如果这一行进行了反转的话，那么这一行的数据是实际值等于  1-A[i][j]
                }
            }
            int k = Math.max(one,m-one);// 判断一多还是0多
            ret += k *(1<<(n-j-1));
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };
        System.out.println(matrixScore(A));
    }
}
