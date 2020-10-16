package com.sh.study.exercise.nine;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * @Author zhouwenchen
 * @Date  2020-10-16
 **/
public class SortedSquares {

    /**
     * 直接计算，使用Arrays.sort 排序
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        if(A == null){
            return A;
        }
        for (int i = 0; i < A.length;i++){
            A[i] = A[i] * A[i];
        }
        // 数组排序 这样效率应该不高的吧
        Arrays.sort(A);
        return A;
    }

    /**
     * 使用双指针的方式实现操作
     * @param A
     * @return
     */
    public static int[] sortedSquares1(int[] A) {
        if(A == null){
            return A;
        }
        int n = A.length;
        // 找到正数和负数的分界线
        int negative = -1;
        for (int i = 0; i < n;i++){
            if(A[i] < 0){
                negative = i;
            }else{
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0;
        // 1：先计算数组的平方
        int i = negative;
        int j = negative + 1;
        while (i >= 0 || j < n){
            if(i < 0){
                ans[index] = A[j] * A[j];
                ++j;
            } else if(j == n){
                ans[index] = A[i] * A[i];
                --i;
            } else if(A[i]*A[i] < A[j] * A[j]){
                ans[index] = A[i] * A[i];
                --i;
            } else{
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;

        }
        return ans;
    }

    /**
     * 双指针，start 和 end ，分别从前后进行判断两个值谁大，
     * @param A
     * @return
     */
    public static int[] sortedSquares2(int[] A) {
        if(A==null){
            return A;
        }
        int n = A.length;
        int[] res = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
          if(A[i] * A[i] > A[j] * A[j]){
              res[pos] =A[i] * A[i];
              ++i;
          } else {
              res[pos] = A[j] * A[j];
              --j;
          }
          --pos;
        }
       return res;
    }

    public static void main(String[] args) {
        Arrays.stream(sortedSquares2(new int[]{-4, -1, 0, 3, 10,11})).forEach(System.out::println);
    }
}
