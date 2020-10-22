package com.sh.study.exercise.nine;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 * @Author zhouwenchen
 * @Data 2020/10/22/16
 **/
public class SortArrayByParity {
    /**
     * 定义两个指针，start = 0  和 end = A.length() -1
     * start 从前往后遍历，直到遇到第一个奇数  ，end 从后往前遍历，直到遇到第一个偶数
     * 交换 start 和 end 位置的元素
     * @param A
     * @return
     */
    public static int[] sortArrayByParity(int[] A) {
        if(A == null || A.length ==1){
            return A;
        }
        int start = 0;
        int end = A.length - 1;
        while (start < end){
            // start 从前往后遍历，直到遇到第一个奇数
            while (start < end  && A[start]%2==0){
                start++;
            }
            while (start < end && A[end]%2 != 0){
                end--;
            }
            swap(A,start,end);
            start++;
            end--;
        }
        return A;
    }

    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }

    /**
     * 922. 按奇偶排序数组 II
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     * 示例：
     *
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     *
     *  思路：
     *  1:使用两个指针实现 start = 0, end = A.length() - 1
     *  2:start 从前遍历，如果 start % 2 == 0 && A[start] % 2 == 0 ,start++
     *    end   从后遍历，如果 end % 2 == 1 && A[start] % 2 == 1,end --
     *  3:否则就交换 swap(A,start,end);
     *  TODO 这种方式没有实现效果
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length == 1){
            return A;
        }
        int start = 0;
        int end = A.length - 1;
        while (start < end){
            // 从前往后遍历， 奇数位置是奇数，偶数位置是偶数
            while (start < end &&  (start % 2 == 0 && A[start] % 2 == 0 || start % 2 == 1 && A[start] % 2 == 1) ){
                start++;
            }
            // 从后往前遍历， 奇数位置是奇数，偶数位置是偶数
            while (start < end && (end % 2 == 0 && A[end] % 2 == 0 || end % 2 == 1 && A[end] % 2 == 1)){
                end--;
            }
            // 需要判断当前 start 和 end 位置是否需要替换
            // TODO 需要判断两个交换的元素是否正式需要替换的
            swap(A,start, end);
            start++;
            end--;
        }
        return A;
    }

    /**
     * 遍历一遍数组，只要保证偶数位置是偶数，那么奇数位置一定都是奇数
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII1(int[] A) {
        if(A == null || A.length == 1){
            return A;
        }

        int j = 1;
        for (int i = 0; i < A.length;i+=2){
            // 奇数
            if(A[i]%2!=0){
                // 需要找到 一个偶数
                while (A[j] % 2 == 1){
                    j+=2;
                }
                swap(A,i,j);
            }
        }

        return A;
    }

    public static void main(String[] args) {
//        Arrays.stream(sortArrayByParity(new int[]{3, 1, 2, 4})).forEach(System.out::println);
//        Arrays.stream(sortArrayByParity(new int[]{0,2})).forEach(System.out::println);
//        Arrays.stream(sortArrayByParityII(new int[]{4,2,5,7})).forEach(System.out::println);
//        Arrays.stream(sortArrayByParityII(new int[]{4,1,2,1})).forEach(System.out::println);
        Arrays.stream(sortArrayByParityII1(new int[]{2,3,1,1,4,0,0,4,3,3})).forEach(System.out::println);
    }
}
