package com.sh.study.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 *
 * @Author zhouwenchen
 * @Data 2020/8/11/20
 **/
public class BubbleSort {

    /**
     * 按升序排列
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        for (int j = 0; j < n; j++) {
            boolean flag = false;
            for (int i = 0; i < n - j - 1; ++i) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 4, 1, 5};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
