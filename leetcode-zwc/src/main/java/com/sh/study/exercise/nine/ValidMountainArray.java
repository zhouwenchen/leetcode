package com.sh.study.exercise.nine;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * @date 20201103
 */
public class ValidMountainArray {
    /**
     * 找到第一个升序的最大值，假如位置在 i，且  A[i] > A[i+1] ，先升序，然后降序
     *
     * @param A
     * @return
     */
    public static boolean validMountainArray(int[] A) {
        // 递增扫描
        int i = 0;
        int len = A.length;
        while ( i+1 < len && A[i] < A[i+1]){
            i++;
        }

        // 判断山脉的的最高点
        if(i == 0 || i == len -1){
            return false;
        }

        // 递减扫描
        while (i+1 < len && A[i] > A[i+1]){
            i++;
        }

        return i == len-1;
    }

    public static void main(String[] args) {
//        int[] A = new int[]{0,3,2,1};
        int[] A = new int[]{3,5,5};
//        int[] A = new int[]{2,1};
//        int[] A = new int[]{2,0,2};
//        int[] A = new int[]{0,1,2,1,2};
        System.out.println(validMountainArray(A));
    }
}
