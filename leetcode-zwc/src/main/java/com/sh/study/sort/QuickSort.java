package com.sh.study.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @Author zhouwenchen
 * @Data 2020/8/12/16
 **/
public class QuickSort {

    public static int quickSort(int[] nums,int start,int end){

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 46, 30, 82, 90, 56, 17, 95, 15 };
        quickSort(nums, 0,nums.length-1);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
