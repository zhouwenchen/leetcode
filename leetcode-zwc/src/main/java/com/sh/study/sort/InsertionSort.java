package com.sh.study.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @Author zhouwenchen
 * @Data 2020/8/11/20
 **/
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort1(int[] arr) {
        if(arr == null || arr.length == 0){
            return;
        }
        int cur;
        for (int i = 0; i < arr.length-1;i++){
            cur = arr[i+1];
            int preIndex = i;
            while (preIndex >=0 && cur < arr[preIndex]){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = cur;
        }
       return;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 3, 2};
//        insertionSort(arr);
//        Arrays.stream(arr).forEach(System.out::print);
//        System.out.println("================");
        insertionSort1(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
