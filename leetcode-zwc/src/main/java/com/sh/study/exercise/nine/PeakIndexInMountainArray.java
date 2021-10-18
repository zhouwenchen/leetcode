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

    /**
     *
     * @date 20200419
     * @author zhouwenchen
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray1(int[] arr) {
        if(arr == null || arr.length < 3){
            return -1;
        }
        int start = 1;
        int end = arr.length - 1;
        while (start < end){
            final int mid = start + ((end-start)>>1);
            final int val = getVale(arr,mid);
            if (val < 0){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;
    }

    private static int getVale(int[] arr, int mid) {
        if(arr[mid -1] < arr[mid] && arr[mid] < arr[mid+1]){
            return -1;
        }
        if(arr[mid -1] < arr[mid] && arr[mid] > arr[mid+1]){
            return 0;
        }
        return 1;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray2(int[] arr) {
        // 找到第一个也就是最大值
        if(arr == null){
            return 0;
        }
        int index = 0;
        for (; index < arr.length - 1; index++) {
            if(arr[index] > arr[index+1]){
                return index;
            }
        }
        return index;
    }

    /**
     * 使用二分查找的方式实现
     *
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray3(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = left +  ((right - left) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
//        System.out.println(peakIndexInMountainArray1(new int[]{0, 1, 2, 1}));
        System.out.println(peakIndexInMountainArray3(new int[]{40,48,61,75,100,99,98,39,30,10}));
    }
}
