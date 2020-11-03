package com.sh.study.exercise.nine;

/**
 * 852. 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 *
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 * @date 2020-10-22
 */
public class PeakIndexInMountainArray {
    /**
     * 顺序遍历，找到第一个  arr[i] > arr[i+1] 的位置，也就是山脉的索引值
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray(int[] arr) {
        if(arr == null){
            return 0;
        }
        int i = 0;
        for (; i < arr.length;i++){
            if(arr[i] > arr[i+1]){
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
//        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 2, 1}));
    }
}
