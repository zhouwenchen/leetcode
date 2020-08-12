package com.sh.study.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author zhouwenchen
 * @Data 2020/8/12/11
 **/
public class MergeSort {

    /**
     * @param arr
     */
    public static void getMergerSort(int[] arr) {
        if (arr == null) {
            return;
        }
        // 新建临时空间
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
    }

    private static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, tmp);
            mergeSort(arr, mid + 1, high, tmp);
            merge(arr, low, mid, high, tmp);
        }
    }

    /**
     * 合并操作
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     * @param tmp
     */
    private static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        int j = low;
        int k = mid + 1;
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        // 判断左右序列中某一个还有剩余的情况
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        while (k <= high) {
            tmp[i++] = arr[k++];
        }

        // 将tmp 复制到 arr 中
        for (int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 44, 23, 67, 88, 65, 34, 48, 9, 12};
        getMergerSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
