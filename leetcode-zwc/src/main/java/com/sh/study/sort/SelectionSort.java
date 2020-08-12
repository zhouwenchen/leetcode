package com.sh.study.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @Author zhouwenchen
 * @Data 2020/8/12/09
 **/
public class SelectionSort {
    /**
     * 已排序 和 未排序 两个部分,从未排序的队列中获取到最小的值，然后将最小值和未排序的第一个元素进行换位置
     * 4,5,6,3,2,1
     * 1,   5,6,3,2,4
     * 1,2,  3,6,5,4
     * 1,2,3 ,4,5,6
     * 1,2,3,4, 5,6
     * 1,2,3,4,5,   6
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int min = 0;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            // 选取最小的值
            min = arr[i];
            k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    k = j;
                }
            }
            // min 是最小值，需要替换 位置 i 的值
            if(i != k){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {5, 2, 8, 4, 9, 1};
        int[] arr = {4,5,6,3,2,1};
        selectionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
