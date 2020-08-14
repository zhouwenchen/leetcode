package com.sh.study.exercise.first;

import java.util.Arrays;

/**
 * 删除排序数据中的重复项
 * {1,1,2}  删除之后就是  {1,2}
 * 如果都删除呢？  {1,1,2} 删除之后就是{2}
 * @Author zhouwenchen
 * @Data 2020-08-2020/8/7-19
 **/
public class RemoveDuplicates {

    /**
     * {1,1,2}  删除之后就是  {1,2}
     * 删除重复项，仅保留一个重复的项
     *
     * @param arr
     * @return
     */
    public static int removeDuplicates(int[] arr){
        if(null == arr){
            return 0;
        }

        int size = 0;
        int first = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != arr[size]){
                arr[++size] = arr[i];
            }
        }
        return size + 1;
    }

    /**
     * {1,1,2} 删除之后就是{2}
     * 删除所有的重复项，都不保留
     *
     * TODO
     * @param arr
     */
    public static int removeDuplicates2(int[] arr){
        if(null == arr){
            return 0;
        }

        int size = 0;
        int first = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != arr[size]){
                arr[++size] = arr[i];
            }
        }
        return size + 1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,1,2,3,4,5,7,7};
        int[] arr = new int[]{1,1,2};
        int i = removeDuplicates(arr);

        System.out.println("test\t"+i);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
